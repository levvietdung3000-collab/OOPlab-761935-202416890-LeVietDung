package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;
    private JScrollPane scrollPane; // Dùng JScrollPane bọc ngoài để định vị lưới chính xác

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Thêm thành phần NORTH (Thanh menu + Tiêu đề AIMS)
        cp.add(createNorth(), BorderLayout.NORTH);

        // Tạo lưới sản phẩm và bọc vào JScrollPane
        JPanel centerPanel = createCenter();
        scrollPane = new JScrollPane(centerPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Xóa đường viền thừa của thanh cuộn

        cp.add(scrollPane, BorderLayout.CENTER);

        setTitle("Store Manager");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Tạo thành phần phía NORTH (gồm MenuBar và Header) [cite: 406, 409]
    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Tạo thanh MenuBar với đầy đủ sự kiện điều hướng [cite: 409]
    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        // Mục View Store: Cập nhật và làm tươi lưới hiển thị [cite: 409, 420]
        JMenuItem viewStoreMenu = new JMenuItem("View store");
        viewStoreMenu.addActionListener(e -> {
            this.remove(scrollPane);

            JPanel centerPanel = createCenter();
            scrollPane = new JScrollPane(centerPanel);
            scrollPane.setBorder(BorderFactory.createEmptyBorder());

            this.add(scrollPane, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
        });
        menu.add(viewStoreMenu);

        // Menu con Update Store chứa các nút thêm sản phẩm [cite: 409, 418]
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> {
            new AddBookToStoreScreen(store); // Mở màn hình thêm Book [cite: 418, 427]
            this.dispose();                  // Đóng màn hình Store hiện tại
        });

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store); // Mở màn hình thêm CD [cite: 418, 427]
            this.dispose();                         // Đóng màn hình Store hiện tại
        });

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store); // Mở màn hình thêm DVD [cite: 418, 427]
            this.dispose();                             // Đóng màn hình Store hiện tại
        });

        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    // Tạo Header tiêu đề hệ thống chữ AIMS màu xanh [cite: 406, 411]
    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    // Tạo lưới hiển thị danh sách sản phẩm (GridLayout 3x3) [cite: 406, 411]
    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 10, 10)); // Đặt hgap và vgap bằng 10 giúp giãn ô thông thoáng [cite: 411]

        ArrayList<Media> mediaInStore = store.getItemsInStore(); // [cite: 411]

        // Hiển thị tối đa 9 sản phẩm đầu tiên có trong Store lên lưới [cite: 411]
        int limit = Math.min(mediaInStore.size(), 9);
        for (int i = 0; i < limit; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i)); // [cite: 411]
            center.add(cell); // [cite: 411]
        }

        // Tạo thêm các ô trống giả lập nếu cửa hàng ít hơn 9 sản phẩm
        // Mục đích: Ép các ô thực tế giữ nguyên tỷ lệ hình vuông ngay ngắn, không bị co giãn dọc
        if (limit > 0 && limit < 9) {
            for (int i = limit; i < 9; i++) {
                JPanel emptyPanel = new JPanel();
                center.add(emptyPanel);
            }
        }

        return center;
    } // Kết thúc phương thức createCenter()
} // Kết thúc toàn bộ class StoreManagerScreen