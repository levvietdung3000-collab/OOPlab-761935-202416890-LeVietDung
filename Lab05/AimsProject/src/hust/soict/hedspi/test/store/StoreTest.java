package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Khởi tạo một cửa hàng mới
        Store store = new Store();

        // 1. Tạo các sản phẩm đa dạng (DVD, Sách, CD)
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        
        Book book = new Book();
        book.setTitle("Harry Potter");
        book.setCategory("Fantasy");
        book.setCost(20.5f);
        
        CompactDisc cd = new CompactDisc("Ado Album", "J-Pop", 25.0f, 0, "Universal", "Ado");
        cd.addTrack(new Track("Kura Kura", 3));

        System.out.println("--- Nhập hàng vào kho ---");
        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);

        store.addMedia(dvd);

        System.out.println("\n--- Xuất hàng khỏi kho ---");
        store.removeMedia(book);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Batman");
        store.removeMedia(dvd4);
    }
}