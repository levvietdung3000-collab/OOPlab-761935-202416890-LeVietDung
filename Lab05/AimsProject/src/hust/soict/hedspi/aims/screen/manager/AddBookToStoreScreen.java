package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book to Store");
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(4, 2, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        center.add(new JLabel("Book Title: "));
        JTextField tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("Book Category: "));
        JTextField tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("Book Cost: "));
        JTextField tfCost = new JTextField();
        center.add(tfCost);

        JButton btnAdd = new JButton("Add to Store");
        btnAdd.addActionListener(e -> {
            Book book = new Book();
            book.setTitle(tfTitle.getText());
            book.setCategory(tfCategory.getText());
            book.setCost(Float.parseFloat(tfCost.getText()));
            store.addMedia(book);
            JOptionPane.showMessageDialog(null, "Đã thêm Sách vào kho thành công!");
            tfTitle.setText(""); tfCategory.setText(""); tfCost.setText("");
        });
        center.add(new JLabel()); // Ô trống
        center.add(btnAdd);

        return center;
    }
}
