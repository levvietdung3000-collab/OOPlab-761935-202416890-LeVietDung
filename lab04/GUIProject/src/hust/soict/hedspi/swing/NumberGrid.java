package hust.soict.hedspi.swing; // Bạn có thể giữ hoặc đổi tên package tùy ý

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        // 1. Thiết lập ô hiển thị số (TextField)
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        tfDisplay.setEditable(false); // Không cho nhập từ bàn phím, chỉ bấm nút

        // 2. Thiết lập bảng chứa các nút bấm (Panel)
        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons); // Gọi hàm khởi tạo nút bên dưới

        // 3. Thiết lập bố cục cho cửa sổ chính (Container)
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH); // Ô hiển thị ở trên
        cp.add(panelButtons, BorderLayout.CENTER); // Các nút ở giữa

        // 4. Các thiết lập cho cửa sổ (JFrame)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(250, 300); // Điều chỉnh kích thước một chút cho đẹp
        setVisible(true);
    }

    // Hàm khởi tạo các nút bấm và gắn sự kiện
    private void addButtons(JPanel panelButtons) {
        ButtonListener listener = new ButtonListener();

        // Tạo các nút từ 0 đến 9
        for (int i = 0; i <= 9; i++) {
            btnNumbers[i] = new JButton(i + "");
            btnNumbers[i].addActionListener(listener);
            panelButtons.add(btnNumbers[i]);
        }

        // Tạo nút Xóa một ký tự (DEL)
        btnDelete = new JButton("DEL");
        btnDelete.addActionListener(listener);
        panelButtons.add(btnDelete);

        // Tạo nút Xóa hết (C - Clear/Reset)
        btnReset = new JButton("C");
        btnReset.addActionListener(listener);
        panelButtons.add(btnReset);
    }

    // Lớp xử lý sự kiện khi bấm nút (Inner Class)
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();

            // Nếu là nút số '0'-'9'
            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + button);
            }
            // Nếu là nút "DEL" - Xóa ký tự cuối cùng
            else if (button.equals("DEL")) {
                String currentText = tfDisplay.getText();
                if (currentText.length() > 0) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
            // Nếu là nút "C" - Xóa toàn bộ
            else if (button.equals("C")) {
                tfDisplay.setText("");
            }
        }
    }

    public static void main(String[] args) {
        // Chạy ứng dụng
        SwingUtilities.invokeLater(() -> new NumberGrid());
    }
}