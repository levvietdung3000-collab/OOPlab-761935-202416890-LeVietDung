package hust.soict.hedspi.aims.screen.customer.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.exception.PlayerException;

public class CartController {

    private Cart cart;
    private Store store;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label costLabel;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    private FilteredList<Media> filteredList;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        // Cài đặt CellValueFactory cho các cột TableView
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // Thiết lập danh sách lọc (FilteredList)
        if (cart != null && cart.getItemsOrdered() != null) {
            filteredList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
            tblMedia.setItems(filteredList);
            
            // Lắng nghe thay đổi của giỏ hàng để cập nhật tổng tiền
            cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> {
                updateTotalCost();
            });
        }

        // Ẩn các nút điều khiển lúc khởi động
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Lắng nghe sự kiện click chọn hàng trong TableView
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });

        // Lắng nghe thay đổi văn bản tìm kiếm trong ô Filter
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        updateTotalCost();
    }

    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        }
    }

    private void updateTotalCost() {
        if (cart != null) {
            costLabel.setText(cart.totalCost() + " $");
        } else {
            costLabel.setText("0 $");
        }
    }

    private void showFilteredMedia(String filterValue) {
        if (filteredList == null) return;
        
        filteredList.setPredicate(media -> {
            if (filterValue == null || filterValue.isEmpty()) {
                return true;
            }
            
            String lowerCaseFilter = filterValue.toLowerCase();
            
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lowerCaseFilter);
            } else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }
            return true;
        });
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
                
                int length = 0;
                if (media instanceof Disc) {
                    length = ((Disc) media).getLength();
                } else if (media instanceof CompactDisc) {
                    length = ((CompactDisc) media).getLength();
                }
                
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Playing Media");
                alert.setHeaderText("Playing: " + media.getTitle());
                alert.setContentText("Length: " + length + " mins");
                alert.showAndWait();
            } catch (PlayerException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Playback Error");
                alert.setHeaderText("Could not play media");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateTotalCost();
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart == null || cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Place Order");
            alert.setHeaderText(null);
            alert.setContentText("Your cart is empty!");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Place Order");
        alert.setHeaderText(null);
        alert.setContentText("Order has been placed successfully!");
        alert.showAndWait();

        cart.getItemsOrdered().clear();
        updateTotalCost();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            ViewStoreController storeController = new ViewStoreController(store, cart);
            fxmlLoader.setController(storeController);
            
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
