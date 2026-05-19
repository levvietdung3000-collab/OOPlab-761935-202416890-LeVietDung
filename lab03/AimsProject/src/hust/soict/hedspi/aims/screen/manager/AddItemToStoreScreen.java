package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store, String title) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Tái sử dụng lại thanh North (Menu + Header)
        cp.add(createNorth(), BorderLayout.NORTH);

        // Thành phần Center sẽ do các lớp con tự vẽ form nhập liệu riêng
        cp.add(createFormCenter(), BorderLayout.CENTER);

        setTitle(title);
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Menu bar có chức năng chuyển đổi màn hình
    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreMenu = new JMenuItem("View store");
        viewStoreMenu.addActionListener(e -> {
            new StoreManagerScreen(store); // Mở lại màn hình chính
            this.dispose();                // Tắt màn hình hiện tại
        });
        menu.add(viewStoreMenu);

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> { new AddBookToStoreScreen(store); this.dispose(); });

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> { new AddCompactDiscToStoreScreen(store); this.dispose(); });

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> { new AddDigitalVideoDiscToStoreScreen(store); this.dispose(); });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JLabel title = new JLabel("AIMS Manager");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        return header;
    }

    // Hàm trừu tượng để các lớp con tự định nghĩa form nhập fields khác nhau
    protected abstract JPanel createFormCenter();
}