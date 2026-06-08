package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Đã nhập '" + media.getTitle() + "' vào kho.");
        } else {
            System.out.println("Sản phẩm '" + media.getTitle() + "' đã có trong kho rồi.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Đã xuất '" + media.getTitle() + "' khỏi kho.");
        } else {
            System.out.println("Sản phẩm không tồn tại trong kho.");
        }
    }
    public Media searchMedia(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
