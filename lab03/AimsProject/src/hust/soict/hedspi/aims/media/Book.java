package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors;

    // --- CONSTRUCTORS ---

    // Constructor 1: Yêu cầu ID (Để giải quyết lỗi đỏ bạn đang gặp)
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
        this.authors = new ArrayList<String>(); // Khởi tạo list trống
    }

    // Constructor 2: Có sẵn danh sách tác giả
    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    // --- PHƯƠNG THỨC QUẢN LÝ TÁC GIẢ ---

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Author '" + authorName + "' is already in the list.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author '" + authorName + "' not found.");
        }
    }

    // --- OVERRIDE toString (Cho bài 16) ---
    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() +
                " - Authors: " + String.join(", ", authors) +
                ": " + getCost() + " $";
    }
}