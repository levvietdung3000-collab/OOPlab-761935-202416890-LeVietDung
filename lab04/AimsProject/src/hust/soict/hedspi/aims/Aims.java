package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen; // Import màn hình GUI quản lý

import java.util.Scanner;
import java.util.Collections;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    // Sửa lỗi Scanner bằng cách khởi tạo luôn tại đây
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. Khởi tạo dữ liệu mẫu để Store không bị trống khi chạy
        initSetup();

        // 2. BẬT THẲNG GIAO DIỆN ĐỒ HỌA LÊN NGAY KHI BẤM RUN
        System.out.println("Opening Store Manager GUI Screen...");
        new StoreManagerScreen(store);

        // 3. Hệ thống Menu dòng lệnh chạy song song bên dưới Terminal
        int choice;
        while (true) {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    store.printStore();
                    handleStoreMenu();
                    break;
                case 2:
                    handleUpdateStoreGUI();
                    break;
                case 3:
                    cart.print();
                    handleCartMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // --- CÁC HÀM XỬ LÝ MENU CHI TIẾT ---

    public static void handleStoreMenu() {
        while (true) {
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 1: // See media details
                    System.out.print("Enter media title: ");
                    String title = scanner.nextLine();
                    Media found = null;
                    for (Media m : store.getItemsInStore()) {
                        if (m.getTitle().equalsIgnoreCase(title)) {
                            found = m;
                            break;
                        }
                    }
                    if (found != null) {
                        System.out.println(found.toString());
                        handleMediaDetailsMenu(found);
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 2: // Add to cart
                    System.out.print("Enter title to add: ");
                    String tAdd = scanner.nextLine();
                    for (Media m : store.getItemsInStore()) {
                        if (m.getTitle().equalsIgnoreCase(tAdd)) {
                            cart.addMedia(m);
                            break;
                        }
                    }
                    break;
                case 3: // Play media
                    System.out.print("Enter title to play: ");
                    String tPlay = scanner.nextLine();
                    for (Media m : store.getItemsInStore()) {
                        if (m.getTitle().equalsIgnoreCase(tPlay)) {
                            playMedia(m);
                            break;
                        }
                    }
                    break;
                case 4: // See cart
                    cart.print();
                    break;
            }
        }
    }

    public static void handleMediaDetailsMenu(Media media) {
        mediaDetailsMenu();
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) cart.addMedia(media);
        else if (choice == 2) playMedia(media);
    }

    public static void handleCartMenu() {
        while (true) {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    break;
                case 2:
                    System.out.println("1. Sort by Title\t2. Sort by Cost");
                    int sChoice = scanner.nextInt();
                    if (sChoice == 1) Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                    else Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                    cart.print();
                    break;
                case 3:
                    System.out.print("Enter title to remove: ");
                    String tRem = scanner.nextLine();
                    for (Media m : cart.getItemsOrdered()) {
                        if (m.getTitle().equalsIgnoreCase(tRem)) {
                            cart.removeMedia(m);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter title to play: ");
                    String tPlay = scanner.nextLine();
                    for (Media m : cart.getItemsOrdered()) {
                        if (m.getTitle().equalsIgnoreCase(tPlay)) {
                            playMedia(m);
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("An order has been created!");
                    cart.getItemsOrdered().clear();
                    break;
            }
        }
    }

    // --- CÁC HÀM TIỆN ÍCH ---

    public static void playMedia(Media m) {
        if (m instanceof Playable) {
            ((Playable) m).play();
        } else {
            System.out.println("This media cannot be played!");
        }
    }

    public static void handleUpdateStoreGUI() {
        System.out.println("Opening Store Manager GUI Screen...");
        new StoreManagerScreen(store);
    }

    private static void initSetup() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        Book book = new Book(1, "Effective Java", "Programming", 45.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store (Open GUI Manager)");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void storeMenu() {
        System.out.println("Store Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void cartMenu() {
        System.out.println("Cart Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }
}