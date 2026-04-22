package hust.soict.hedspi.aims.media;
import java.util.Comparator;
public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    // Constructor chỉ có title (để hỗ trợ các trường hợp tìm kiếm hoặc khởi tạo nhanh)
    public Media(String title) {
        this.title = title;
    }

    // Constructor đầy đủ tham số để các lớp con (DVD, Book, CD) gọi super(...)
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // --- Các phương thức Getter (Giữ lại tất cả) ---
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    @Override
    public boolean equals(Object obj) {
        // 1. Kiểm tra xem đối tượng truyền vào có phải chính là đối tượng này không
        if (this == obj) return true;

        // 2. Kiểm tra xem đối tượng truyền vào có null hoặc khác lớp không
        if (obj == null || !(obj instanceof Media)) return false;

        // 3. Ép kiểu về Media để so sánh thuộc tính
        Media other = (Media) obj;

        // 4. So sánh title (Yêu cầu: title giống nhau là bằng nhau)
        if (this.title == null) return other.title == null;
        return this.title.equalsIgnoreCase(other.title);
    }
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}