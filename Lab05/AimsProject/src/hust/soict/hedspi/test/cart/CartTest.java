package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Khởi tạo giỏ hàng
        Cart cart = new Cart();

        // 1. Tạo các đĩa DVD và thêm vào giỏ bằng hàm addMedia
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        // 2. Tạo thêm một cuốn Sách để test tính năng Đa hình
        Book book1 = new Book();
        book1.setTitle("Java Programming");
        book1.setCategory("Education");
        book1.setCost(15.5f);
        cart.addMedia(book1);

        // Test hàm in danh sách (Sẽ in ra cả DVD và Sách)
        System.out.println("\n--- In Giỏ Hàng ---");
        cart.print();

        // Test các hàm tìm kiếm
        System.out.println("\n--- Test Search by ID ---");
        cart.searchById(2); // Tìm sản phẩm có ID = 2
        cart.searchById(99); // Tìm sản phẩm không tồn tại

        System.out.println("\n--- Test Search by Title ---");
        cart.searchByTitle("Star"); // Tìm sản phẩm có chữ Star
        cart.searchByTitle("Java"); // Tìm sản phẩm có chữ Java
        cart.searchByTitle("Batman"); // Tìm sản phẩm không tồn tại
    }
}