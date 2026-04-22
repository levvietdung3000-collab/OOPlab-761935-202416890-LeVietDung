package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh theo giá (giảm dần)
        int costDiff = Float.compare(m2.getCost(), m1.getCost());
        if (costDiff != 0) {
            return costDiff;
        }
        // Nếu giá bằng nhau, so sánh theo tiêu đề (A-Z)
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}