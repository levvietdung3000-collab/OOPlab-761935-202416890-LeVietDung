package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.Book;

public class BookTest {
    public static void main(String[] args) {
        // Tạo một cuốn sách mới
        Book myBook = new Book();
        myBook.setTitle("Lập trình Java cơ bản");
        
        System.out.println("Tên sách: " + myBook.getTitle());

        System.out.println("\n--- Thử nghiệm THÊM tác giả ---");
        myBook.addAuthor("Nguyen Van A");
        myBook.addAuthor("Tran Thi B");
        // Thử thêm trùng lặp một tác giả đã có
        myBook.addAuthor("Nguyen Van A"); 

        System.out.println("\n--- Thử nghiệm XÓA tác giả ---");
        myBook.removeAuthor("Tran Thi B");
        // Thử xóa một tác giả không tồn tại
        myBook.removeAuthor("Le Van C"); 
    }
}
