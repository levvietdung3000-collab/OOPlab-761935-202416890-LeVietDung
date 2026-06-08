package hust.soict.hedspi.aims.media;
import java.util.Comparator;
public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {
        // Constructor mặc định
    }

    // --- GETTERS & SETTERS ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Media)) {
            return false;
        }
        Media other = (Media) obj;
        if (this.title == null || other.title == null) {
            return false;
        }
        return this.title.equals(other.title) && this.cost == other.cost;
    }

    @Override
    public int compareTo(Media other) {
        if (other == null) {
            throw new NullPointerException("Cannot compare to a null Media object.");
        }
        if (this.title == null && other.title != null) return -1;
        if (this.title != null && other.title == null) return 1;
        if (this.title != null && other.title != null) {
            int titleCompare = this.title.compareTo(other.title);
            if (titleCompare != 0) {
                return titleCompare;
            }
        }
        return Float.compare(this.cost, other.cost);
    }

    @Override
    public String toString() {
        return "Media - [" + this.getTitle() + "] - [" + this.getCategory() + "]: " + this.getCost() + " $";
    }
}
