package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh theo Tên
        int titleComparison = m1.getTitle().compareTo(m2.getTitle());
        if (titleComparison != 0) {
            return titleComparison; 
        }
        // Nếu trùng Tên, sắp xếp theo Giá
        return Float.compare(m2.getCost(), m1.getCost());
    }
}