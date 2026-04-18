package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        // 1. Khởi tạo cửa hàng
        Store myStore = new Store();

        // 2. Tạo một vài đĩa DVD để test
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        // 3. Test phương thức thêm (addDVD)
        myStore.addDVD(dvd1);
        myStore.addDVD(dvd2);
        myStore.addDVD(dvd3);

        // 4. Test phương thức xóa (removeDVD)
        myStore.removeDVD(dvd2); // Xóa đĩa Star Wars
        myStore.removeDVD(dvd2); // Thử xóa lại đĩa đã xóa (để test thông báo lỗi)
    }
}