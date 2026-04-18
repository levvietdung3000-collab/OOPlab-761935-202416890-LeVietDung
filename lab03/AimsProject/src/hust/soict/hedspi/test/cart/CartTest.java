package hust.soict.hedspi.test.cart;

// Phải import Cart và DVD vì chúng nằm ở các package khác
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // 1. Tạo một giỏ hàng mới
        Cart cart = new Cart();

        // 2. Tạo các đối tượng DVD mới và thêm vào giỏ hàng
        // Lưu ý: Các tham số truyền vào phải khớp với Constructor bạn đã viết ở lớp DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // 3. Kiểm tra phương thức in giỏ hàng (Yêu cầu 4.1)
        cart.print();

        // 4. Kiểm tra các phương thức tìm kiếm (Yêu cầu 4.2 & 4.3)

        // Thử tìm kiếm theo ID
        System.out.println("\n--- Testing Search by ID ---");
        cart.searchById(1); // Tìm thấy
        cart.searchById(10); // Không tìm thấy

        // Thử tìm kiếm theo tiêu đề
        System.out.println("\n--- Testing Search by Title ---");
        cart.searchByTitle("Star Wars"); // Khớp hoàn toàn
        cart.searchByTitle("lion");      // Khớp một phần (vì dùng isMatch có toLowerCase)
        cart.searchByTitle("Batman");    // Không tìm thấy
    }
}