package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;

public class Store {
    // 1. Khai báo thuộc tính (Nên để private để đảm bảo tính đóng gói)
    private ArrayList<Media> itemsInStore;

    // 2. CẬP NHẬT CONSTRUCTOR (Yêu cầu trọng tâm bài 14)
    // Constructor khởi tạo danh sách các phần tử trong cửa hàng
    public Store() {
        this.itemsInStore = new ArrayList<Media>();
        // Việc khởi tạo ở đây đảm bảo "aggregate class" đã sẵn sàng cho các "parts" của nó.
    }

    // Phương thức thêm Media vào cửa hàng
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Added " + media.getTitle() + " to the store.");
        } else {
            System.out.println("The media " + media.getTitle() + " is already in the store.");
        }
    }

    // Phương thức xóa Media khỏi cửa hàng
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Removed " + media.getTitle() + " from the store.");
        } else {
            System.out.println("The media " + media.getTitle() + " was not found!");
        }
    }

    // Phương thức hiển thị danh sách trong kho để kiểm tra
    public void printStore() {
        System.out.println("*********************** STORE ***********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
        System.out.println("*****************************************************");
    }

    // Getter cho itemsInStore (Nếu các lớp khác như Aims cần truy cập danh sách)
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}