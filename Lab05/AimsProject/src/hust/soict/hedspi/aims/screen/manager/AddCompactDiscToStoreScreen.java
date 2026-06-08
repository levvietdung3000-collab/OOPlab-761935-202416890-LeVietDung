package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD to Store");
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(4, 2, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        center.add(new JLabel("CD Title: "));
        JTextField tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("CD Category: "));
        JTextField tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("CD Cost: "));
        JTextField tfCost = new JTextField();
        center.add(tfCost);

        JButton btnAdd = new JButton("Add to Store");
        btnAdd.addActionListener(e -> {
            // Giả sử có constructor 3 tham số, nếu báo lỗi thì cậu chủ sửa lại thành set giống bên Sách nhé
            CompactDisc cd = new CompactDisc(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText()), 0, "", "");
            store.addMedia(cd);
            JOptionPane.showMessageDialog(null, "Đã thêm CD vào kho thành công!");
            tfTitle.setText(""); tfCategory.setText(""); tfCost.setText("");
        });
        center.add(new JLabel());
        center.add(btnAdd);

        return center;
    }
}