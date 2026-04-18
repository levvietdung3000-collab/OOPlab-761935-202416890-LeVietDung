package hust.soict.hedspi.aims.disc; // Đã sửa package

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    private static int nbDigitalVideoDiscs = 0;
    private int id;

    // --- BỔ SUNG CÁC PHƯƠNG THỨC MỚI THEO YÊU CẦU ---

    // 1. Phải có Getter cho ID để Cart search được
    public int getId() {
        return id;
    }

    // 2. Viết hàm isMatch để tìm kiếm (Mục 4.3)
    public boolean isMatch(String title) {
        // Trả về true nếu tiêu đề chứa từ khóa (không phân biệt hoa thường)
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

    // 3. Ghi đè toString để in đúng định dạng (Mục 4.1)
    @Override
    public String toString() {
        return "DVD - " + title + " - "
                + (category != null ? category : "N/A") + " - "
                + (director != null ? director : "N/A") + " - "
                + length + ": " + cost + " $";
    }

    // --- CÁC GETTER/SETTER CỦA BẠN (GIỮ NGUYÊN) ---
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    public int getLength() { return length; }
    public void setLength(int length) { this.length = length; }
    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }

    // --- CÁC CONSTRUCTOR (ĐÃ TỐI ƯU HÓA) ---

    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title); // Gọi constructor ở trên để tăng ID
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, cost);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(title, category, director, cost);
        this.length = length;
    }
}