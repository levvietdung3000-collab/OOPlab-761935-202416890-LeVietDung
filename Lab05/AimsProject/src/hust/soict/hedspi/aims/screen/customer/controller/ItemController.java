package hust.soict.hedspi.aims.screen.customer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;

public class ItemController {

    private Media media;
    private Cart cart;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    private HBox hboxButtons;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        if (cart != null && media != null) {
            cart.addMedia(media);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Add to Cart");
            alert.setHeaderText(null);
            alert.setContentText("Added " + media.getTitle() + " to cart!");
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
                
                // Show standard JavaFX Alert to simulate playing
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
}
