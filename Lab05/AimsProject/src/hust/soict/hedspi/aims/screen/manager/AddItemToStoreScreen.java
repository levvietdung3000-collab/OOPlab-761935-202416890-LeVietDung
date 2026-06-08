package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER); // Phần Center sẽ để cho các lớp con tự định nghĩa

        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStoreMenu = new JMenuItem("View store");
        menu.add(viewStoreMenu);
        
        // Sự kiện quay lại màn hình chính
        viewStoreMenu.addActionListener(e -> {
            new StoreManagerScreen(store);
            dispose(); // Đóng cửa sổ hiện tại
        });

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookMenu = new JMenuItem("Add Book");
        JMenuItem addCDMenu = new JMenuItem("Add CD");
        JMenuItem addDVDMenu = new JMenuItem("Add DVD");

        // Sự kiện chuyển tab giữa các màn hình Add
        addBookMenu.addActionListener(e -> { new AddBookToStoreScreen(store); dispose(); });
        addCDMenu.addActionListener(e -> { new AddCompactDiscToStoreScreen(store); dispose(); });
        addDVDMenu.addActionListener(e -> { new AddDigitalVideoDiscToStoreScreen(store); dispose(); });

        smUpdateStore.add(addBookMenu);
        smUpdateStore.add(addCDMenu);
        smUpdateStore.add(addDVDMenu);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
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

    // Phương thức trừu tượng yêu cầu các lớp con phải tự thiết kế form nhập liệu riêng
    abstract JPanel createCenter();
}
