package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.exception.PlayerException;

public class TestPlayable {
    public static void main(String[] args) {
        // 1. Tạo một đĩa DVD và test tính năng play()
        System.out.println("--- TEST DVD PLAY ---");
        DigitalVideoDisc dvd = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        try {
            dvd.play();
        } catch (PlayerException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- TEST CD PLAY ---");
        // 2. Tạo một đĩa CD
        CompactDisc cd = new CompactDisc("Ado Special", "J-Pop", 15.50f, 0, "Universal Music", "Ado");
        
        // 3. Tạo các bài hát (Track) và thêm vào CD
        Track track1 = new Track("Usseewa", 4);
        Track track2 = new Track("Kura Kura", 3); 
        Track track3 = new Track("Show", 3);
        
        cd.addTrack(track1);
        cd.addTrack(track2);
        cd.addTrack(track3);

        System.out.println("\nBắt đầu phát CD:");
        try {
            cd.play();
        } catch (PlayerException e) {
            e.printStackTrace();
        }
    }
}