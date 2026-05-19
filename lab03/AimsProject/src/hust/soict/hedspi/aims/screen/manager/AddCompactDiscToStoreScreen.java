package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfArtist;
    private JTextField tfCost;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD to Store");
        setVisible(true);
    }

    @Override
    protected JPanel createFormCenter() {
        // Form nhập liệu gồm 5 hàng, 2 cột (4 hàng thông tin + 1 hàng nút bấm)
        JPanel center = new JPanel(new GridLayout(5, 2, 10, 10));

        center.add(new JLabel("Title: "));
        tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("Category: "));
        tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("Artist: "));
        tfArtist = new JTextField();
        center.add(tfArtist);

        center.add(new JLabel("Cost: "));
        tfCost = new JTextField();
        center.add(tfCost);

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            try {
                // 1. Lấy dữ liệu từ các ô nhập liệu
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String artist = tfArtist.getText();
                float cost = Float.parseFloat(tfCost.getText());

                // 2. Tự động sinh ID dựa trên kích thước store hiện tại
                int id = store.getItemsInStore().size() + 1;

                // 3. Khởi tạo đối tượng CompactDisc bằng constructor rút gọn của bạn
                CompactDisc cd = new CompactDisc(id, title, category, cost, artist);

                // 4. Thêm đối tượng vào Store hàng hóa
                store.addMedia(cd);

                JOptionPane.showMessageDialog(this, "CD '" + title + "' added successfully!");

                // 5. Quay về màn hình quản lý chính và giải phóng form hiện tại
                new StoreManagerScreen(store);
                this.dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number for Cost!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        center.add(new JLabel("")); // Ô trống giữ vị trí cho grid cân đối
        center.add(btnAdd);

        return center;
    }
}