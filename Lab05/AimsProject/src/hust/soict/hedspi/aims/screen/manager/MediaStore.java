package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.exception.PlayerException;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Nút Play chỉ hiện nếu Media đó implement interface Playable
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> {
                try {
                    ((Playable) media).play();
                    
                    // Tạo một hộp thoại JDialog khi bấm Play
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Media Player");
                    dialog.setSize(300, 150);
                    dialog.setLayout(new BorderLayout());
                    
                    JLabel playLabel = new JLabel("Đang phát: " + media.getTitle());
                    playLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    playLabel.setFont(new Font("Arial", Font.BOLD, 16));
                    
                    dialog.add(playLabel, BorderLayout.CENTER);
                    dialog.setLocationRelativeTo(null); 
                    dialog.setVisible(true);
                } catch (PlayerException pe) {
                    JOptionPane.showMessageDialog(null, pe.getMessage(), "Illegal Media Length", JOptionPane.ERROR_MESSAGE);
                }
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}