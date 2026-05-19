package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;
import java.util.Collections;
public class Cart {
    // 1. Khai báo thuộc tính
    private ArrayList<Media> itemsOrdered;

    // 2. CẬP NHẬT CONSTRUCTOR (Yêu cầu bài 14)
    public Cart() {
        // Khởi tạo thành phần con ngay khi đối tượng Cart được tạo
        this.itemsOrdered = new ArrayList<Media>();
    }

    // --- CÁC PHƯƠNG THỨC QUẢN LÝ ---

    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("The media " + media.getTitle() + " is already in the cart.");
        } else {
            itemsOrdered.add(media);
            System.out.println("Added: " + media.getTitle());
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Media " + media.getTitle() + " not found in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // --- PHƯƠNG THỨC HIỂN THỊ VÀ TÌM KIẾM ---

    public void print() {
        System.out.println("*********************** CART ***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found match: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No media found with ID: " + id);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found match: " + media.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No media found with title: " + title);
    }

    // Getter phục vụ cho các chức năng sắp xếp hoặc lọc sau này
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by Title.");
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by Cost.");
    }
    public void emptyCart() {
        itemsOrdered.clear();
        System.out.println("The cart is now empty.");
    }
}