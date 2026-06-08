package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD to Store");
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(4, 2, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        center.add(new JLabel("DVD Title: "));
        JTextField tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("DVD Category: "));
        JTextField tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("DVD Cost: "));
        JTextField tfCost = new JTextField();
        center.add(tfCost);

        JButton btnAdd = new JButton("Add to Store");
        btnAdd.addActionListener(e -> {
            DigitalVideoDisc dvd = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText()));
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(null, "Đã thêm DVD vào kho thành công!");
            tfTitle.setText(""); tfCategory.setText(""); tfCost.setText("");
        });
        center.add(new JLabel());
        center.add(btnAdd);

        return center;
    }
}