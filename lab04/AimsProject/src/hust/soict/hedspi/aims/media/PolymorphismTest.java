package hust.soict.hedspi.aims.media; // Tùy bạn đặt package

import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;
import java.util.List;

public class PolymorphismTest {
    public static void main(String[] args) {
        // 1. Tạo một danh sách kiểu Media (Lớp cha)
        List<Media> mediae = new ArrayList<Media>();

        // 2. Thêm các đối tượng con khác nhau vào danh sách
        // Bỏ số 1 (id) đi và sắp xếp lại đúng thứ tự: Title, Category, Director, Length, Cost
        Media dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Media book = new Book(2, "Java Programming", "Education", 25.00f);
        Media cd = new CompactDisc(3, "Starboy", "Pop", 15.00f, "The Weeknd");

        mediae.add(dvd);
        mediae.add(book);
        mediae.add(cd);

        // 3. Duyệt danh sách và in ra thông tin
        for (Media m : mediae) {
            // Đây chính là ĐA HÌNH:
            // Cùng gọi hàm toString() nhưng mỗi loại Media sẽ tự in ra kiểu riêng của nó
            System.out.println(m.toString());
        }
    }
}