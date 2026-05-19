package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD to Store");
        setVisible(true);
    }

    @Override
    protected JPanel createFormCenter() {
        // Bố cục lưới gồm 6 hàng, 2 cột (5 hàng dữ liệu + 1 hàng nút bấm)
        JPanel center = new JPanel(new GridLayout(6, 2, 10, 10));

        center.add(new JLabel("Title: "));
        tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("Category: "));
        tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("Director: "));
        tfDirector = new JTextField();
        center.add(tfDirector);

        center.add(new JLabel("Length: "));
        tfLength = new JTextField();
        center.add(tfLength);

        center.add(new JLabel("Cost: "));
        tfCost = new JTextField();
        center.add(tfCost);

        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(e -> {
            try {
                // 1. Thu thập dữ liệu từ giao diện nhập liệu
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String director = tfDirector.getText();
                int length = Integer.parseInt(tfLength.getText());
                float cost = Float.parseFloat(tfCost.getText());

                // 2. Gọi constructor 5 tham số của bạn (tự động xử lý ID nội bộ)
                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);

                // 3. Thêm đối tượng vào hệ thống lưu trữ dữ liệu cửa hàng
                store.addMedia(dvd);

                JOptionPane.showMessageDialog(this, "DVD '" + title + "' added successfully!");

                // 4. Giải phóng màn hình nhập và mở lại màn hình quản lý chính
                new StoreManagerScreen(store);
                this.dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number for Length and Cost!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        center.add(new JLabel("")); // Ô trống giữ vị trí giúp căn đều giao diện
        center.add(btnAdd);

        return center;
    }
}