package hust.soict.hedspi.aims.cart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import hust.soict.hedspi.aims.media.Media;

public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    // Thêm sản phẩm (Media) vào giỏ
    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Đã thêm '" + media.getTitle() + "' vào giỏ hàng.");
        } else {
            System.out.println("Sản phẩm '" + media.getTitle() + "' đã có sẵn trong giỏ.");
        }
    }

    // Xóa sản phẩm khỏi giỏ
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Đã xóa '" + media.getTitle() + "' khỏi giỏ hàng.");
        } else {
            System.out.println("Không tìm thấy '" + media.getTitle() + "' để xóa.");
        }
    }

    // Tính tổng tiền bằng cách duyệt danh sách Media
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // In giỏ hàng
    public void print() {
        System.out.println("***********************GIỎ HÀNG***********************");
        System.out.println("Danh sách sản phẩm:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Tổng chi phí: " + totalCost() + " $");
        System.out.println("******************************************************");
    }

    // Tìm kiếm theo tên (Title)
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Tìm thấy: " + media.toString());
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy sản phẩm nào có tên: " + title);
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Tìm thấy ID " + id + ": " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào có ID: " + id);
        }
    }

    public void sortByTitleCost() {
        FXCollections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Đã sắp xếp giỏ hàng theo Tên -> Giá.");
    }

    public void sortByCostTitle() {
        FXCollections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Đã sắp xếp giỏ hàng theo Giá -> Tên.");
    }

    public Media searchMedia(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    // Getter cho itemsOrdered để dùng với JavaFX TableView
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}