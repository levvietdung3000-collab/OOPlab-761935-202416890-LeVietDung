package hust.soict.hedspi.aims.media;

public abstract class Disc extends Media {
    private String director;
    private int length;

    // --- Các hàm Getter ---
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    // --- Constructor (Cập nhật theo yêu cầu bài 14) ---

    // Constructor đầy đủ để các lớp con (DVD, CD) gọi tới thông qua super()
    public Disc(int id, String title, String category, float cost, String director, int length) {
        // Gọi lên constructor của lớp cha Media
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    // Bạn có thể thêm constructor phụ nếu muốn tạo đĩa chưa rõ đạo diễn/độ dài
    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
}