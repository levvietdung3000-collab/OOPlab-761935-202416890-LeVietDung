package hust.soict.hedspi.aims.screen.customer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;

public class AimsCustomerApp extends Application {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    @Override
    public void start(Stage stage) throws Exception {
        // Khởi tạo dữ liệu mẫu
        initSetup();

        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController storeController = new ViewStoreController(store, cart);
        fxmlLoader.setController(storeController);
        
        Parent root = fxmlLoader.load();
        stage.setTitle("AIMS - Customer View");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void initSetup() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin (Invalid Length)", "Animation", "John Musker", 0, 18.99f); // length 0 to test exception
        
        CompactDisc cd = new CompactDisc("Ado Special", "J-Pop", 25.5f, 0, "N/A", "Ado");
        cd.addTrack(new Track("Kura Kura", 3));
        cd.addTrack(new Track("Show", 4));
        cd.addTrack(new Track("Zero Length Track", 0)); // zero length to test exception

        Book book = new Book();
        book.setTitle("Java Programming");
        book.setCategory("Education");
        book.setCost(50.0f);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(cd);
        store.addMedia(book);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
