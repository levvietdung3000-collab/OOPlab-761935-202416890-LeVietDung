package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book to Store");
        setVisible(true);
    }

    @Override
    protected JPanel createFormCenter() {
        JPanel center = new JPanel(new GridLayout(4, 2, 10, 10));

        center.add(new JLabel("Title: "));
        tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("Category: "));
        tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("Cost: "));
        tfCost = new JTextField();
        center.add(tfCost);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                float cost = Float.parseFloat(tfCost.getText());

                // Tự động sinh id bằng size() + 1 để khớp với constructor 4 tham số của lớp Book
                int id = store.getItemsInStore().size() + 1;
                Book book = new Book(id, title, category, cost);

                store.addMedia(book);

                JOptionPane.showMessageDialog(this, "Book added successfully!");

                // Quay về màn hình quản lý chính
                new StoreManagerScreen(store);
                this.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number for Cost!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        center.add(new JLabel(""));
        center.add(btnAdd);

        return center;
    }
}