package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
    private int qtyOrdered = 0;
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    // --- CÁC HÀM ADD/REMOVE CỦA BẠN (GIỮ NGUYÊN) ---
    public void addDigitalVideoDisc(DigitalVideoDisc item) {
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
        } else {
            itemOrdered[qtyOrdered] = item;
            qtyOrdered++;
            System.out.println("Added: " + item.getTitle());
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc item) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].equals(item)) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemOrdered[j] = itemOrdered[j + 1];
                }
                itemOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("Removed: " + item.getTitle());
                break;
            }
        }
        if (!found) System.out.println("DVD not found");
    }

    // --- CÁC HÀM UPDATE MỚI THEO YÊU CẦU LAB 03 ---

    // 1. Hàm tính tổng tiền (Đã sửa lỗi: đưa biến total vào trong hàm)
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemOrdered[i].getCost();
        }
        return total;
    }

    // 2. Hàm in giỏ hàng (Yêu cầu 4.1)
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            // Sử dụng hàm toString() đã viết bên DigitalVideoDisc
            System.out.println((i + 1) + ". " + itemOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // 3. Tìm kiếm theo ID (Yêu cầu 4.2)
    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].getId() == id) {
                System.out.println("Found match: " + itemOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID: " + id);
        }
    }

    // 4. Tìm kiếm theo Title (Yêu cầu 4.3)
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            // Sử dụng hàm isMatch() đã viết bên DigitalVideoDisc
            if (itemOrdered[i].isMatch(title)) {
                System.out.println("Found match: " + itemOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title: " + title);
        }
    }
}