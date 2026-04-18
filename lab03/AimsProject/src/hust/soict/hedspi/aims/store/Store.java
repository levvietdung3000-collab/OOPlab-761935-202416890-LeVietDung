package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    // Mảng chứa các DVD trong cửa hàng (giới hạn tạm thời 100 phần tử)
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100];
    private int qtyInStore = 0; // Biến đếm số lượng thực tế trong kho

    // Phương thức thêm DVD vào cửa hàng
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < itemsInStore.length) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("Đã thêm DVD: " + dvd.getTitle() + " vào cửa hàng.");
        } else {
            System.out.println("Cửa hàng đã đầy, không thể thêm mới!");
        }
    }

    // Phương thức xóa DVD khỏi cửa hàng
    public void removeDVD(DigitalVideoDisc dvd) {
        int foundIndex = -1;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].equals(dvd)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            // Dồn các phần tử phía sau lên để lấp chỗ trống
            for (int i = foundIndex; i < qtyInStore - 1; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }
            itemsInStore[qtyInStore - 1] = null;
            qtyInStore--;
            System.out.println("Đã xóa DVD: " + dvd.getTitle() + " khỏi cửa hàng.");
        } else {
            System.out.println("Không tìm thấy DVD này trong cửa hàng!");
        }
    }
}