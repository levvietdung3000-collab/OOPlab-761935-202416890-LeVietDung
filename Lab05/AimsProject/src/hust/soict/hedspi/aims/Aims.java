package hust.soict.hedspi.aims;

import java.util.Scanner;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.exception.PlayerException;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initSetup();

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCart();
                    break;
                case 0:
                    System.out.println("Cảm ơn quý khách đã sử dụng AIMS. Hẹn gặp lại!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store (Xem cửa hàng)");
        System.out.println("2. Update store (Cập nhật cửa hàng)");
        System.out.println("3. See current cart (Xem giỏ hàng)");
        System.out.println("0. Exit (Thoát)");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details (Xem chi tiết)");
        System.out.println("2. Add a media to cart (Thêm vào giỏ)");
        System.out.println("3. Play a media (Phát thử)");
        System.out.println("4. See current cart (Xem giỏ hàng)");
        System.out.println("0. Back (Quay lại)");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart (Thêm vào giỏ)");
        System.out.println("2. Play (Phát thử)");
        System.out.println("0. Back (Quay lại)");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart (Lọc giỏ hàng)");
        System.out.println("2. Sort media in cart (Sắp xếp giỏ hàng)");
        System.out.println("3. Remove media from cart (Xóa khỏi giỏ)");
        System.out.println("4. Play a media (Phát thử)");
        System.out.println("5. Place order (Đặt hàng)");
        System.out.println("0. Back (Quay lại)");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void viewStore() {
        System.out.println("\n--- CÁC SẢN PHẨM TRONG CỬA HÀNG ---");
        System.out.println("1. The Lion King (DVD)");
        System.out.println("2. Star Wars (DVD)");
        System.out.println("3. Ado Special (CD)");
        System.out.println("4. Java Programming (Book)");

        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên sản phẩm muốn xem chi tiết: ");
                    String title = scanner.nextLine();
                    Media media = store.searchMedia(title);
                    if (media != null) {
                        System.out.println(media.toString());
                        mediaDetailsMenuHandler(media);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm!");
                    }
                    break;
                case 2: // Thêm vào giỏ
                    System.out.print("Nhập tên sản phẩm muốn thêm vào giỏ: ");
                    String addTitle = scanner.nextLine();
                    Media addMedia = store.searchMedia(addTitle);
                    if (addMedia != null) {
                        cart.addMedia(addMedia);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm!");
                    }
                    break;
                case 3: // Play
                    System.out.print("Nhập tên sản phẩm muốn phát thử: ");
                    String playTitle = scanner.nextLine();
                    Media playMedia = store.searchMedia(playTitle);
                    if (playMedia != null) {
                        if (playMedia instanceof Playable) {
                            try {
                                ((Playable) playMedia).play();
                            } catch (PlayerException e) {
                                System.err.println(e.getMessage());
                                System.err.println(e.toString());
                                e.printStackTrace();
                                javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "Illegal Media Length", javax.swing.JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            System.out.println("Sản phẩm này không hỗ trợ phát thử (Play)!");
                        }
                    } else {
                        System.out.println("Không tìm thấy sản phẩm!");
                    }
                    break;
                case 4:
                    seeCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    public static void mediaDetailsMenuHandler(Media media) {
        int choice;
        do {
            mediaDetailsMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        try {
                            ((Playable) media).play();
                        } catch (PlayerException e) {
                            System.err.println(e.getMessage());
                            System.err.println(e.toString());
                            e.printStackTrace();
                            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "Illegal Media Length", javax.swing.JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        System.out.println("Sản phẩm này là Sách, không thể phát (Play) được!");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    public static void updateStore() {
        System.out.println("\nTính năng cập nhật kho hàng (Thêm/Xóa) đang được xây dựng...");
    }

    public static void seeCart() {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Chức năng lọc đang được phát triển...");
                    break;
                case 2:
                    System.out.println("1. Sắp xếp theo Tên | 2. Sắp xếp theo Giá");
                    int sortChoice = scanner.nextInt();
                    if (sortChoice == 1) cart.sortByTitleCost(); 
                    else if (sortChoice == 2) cart.sortByCostTitle();
                    cart.print();
                    break;
                case 3:
                    System.out.print("Nhập tên sản phẩm muốn xóa khỏi giỏ: ");
                    String removeTitle = scanner.nextLine();
                    Media removeMedia = cart.searchMedia(removeTitle); 
                    if (removeMedia != null) cart.removeMedia(removeMedia);
                    else System.out.println("Không tìm thấy trong giỏ!");
                    break;
                case 4:
                    System.out.print("Nhập tên sản phẩm muốn phát thử: ");
                    String playTitle = scanner.nextLine();
                    Media playMedia = cart.searchMedia(playTitle);
                    if (playMedia != null && playMedia instanceof Playable) {
                        try {
                            ((Playable) playMedia).play();
                        } catch (PlayerException e) {
                            System.err.println(e.getMessage());
                            System.err.println(e.toString());
                            e.printStackTrace();
                            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "Illegal Media Length", javax.swing.JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        System.out.println("Không thể phát!");
                    }
                    break;
                case 5:
                    System.out.println("Đơn hàng đã được tạo thành công! Giỏ hàng đã được làm trống.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0 && choice != 5);
    }

    // Hàm tạo dữ liệu
    public static void initSetup() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);
        CompactDisc cd = new CompactDisc("Ado Special", "J-Pop", 25.5f, 0, "N/A", "Ado");
        cd.addTrack(new Track("Kura Kura", 3));
        store.addMedia(cd);
        Book book = new Book();
        book.setTitle("Java Programming");
        store.addMedia(book);
    }
}