package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Tiêu đề sản phẩm [cite: 414]
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        // Giá sản phẩm [cite: 414]
        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        // Panel chứa nút bấm [cite: 414]
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // ĐÃ GỘP VÀ CHỈ GIỮ LẠI 1 KHỐI KIỂM TRA DUY NHẤT TẠI ĐÂY [cite: 414]
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");

            // Đấu nối hành động xử lý sự kiện khi nhấn nút Play [cite: 417, 421]
            playButton.addActionListener(e -> {
                // Tạo một cửa sổ hộp thoại con JDialog [cite: 421, 422]
                JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Playing Media", true);
                dialog.setLayout(new FlowLayout());

                JLabel playLabel = new JLabel("Now playing: " + media.getTitle());
                JButton closeButton = new JButton("Close");
                closeButton.addActionListener(evt -> dialog.dispose());

                dialog.add(playLabel);
                dialog.add(closeButton);
                dialog.setSize(300, 150);
                dialog.setLocationRelativeTo(this);
                dialog.setVisible(true);
            });

            // Chỉ đưa đúng 1 nút Play duy nhất vào container [cite: 414]
            container.add(playButton);
        }

        // Sắp xếp bố cục hiển thị các thành phần vào ô sản phẩm [cite: 414]
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        // Đổ viền đen bao bọc quanh ô sản phẩm để phân tách lưới [cite: 414]
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}