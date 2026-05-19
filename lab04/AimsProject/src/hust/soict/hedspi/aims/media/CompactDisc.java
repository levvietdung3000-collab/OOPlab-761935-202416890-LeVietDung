package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks; // Chỉ khai báo, không khởi tạo tại đây

    // --- CÁC CONSTRUCTOR (Cập nhật theo bài 14) ---

    // Constructor đầy đủ tham số
    public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist) {
        super(id, title, category, cost, director, length);
        this.artist = artist;
        this.tracks = new ArrayList<Track>(); // Khởi tạo danh sách tại đây (Aggregation)
    }

    // Constructor rút gọn (thường dùng)
    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title, category, cost, null, 0);
        this.artist = artist;
        this.tracks = new ArrayList<Track>(); // Khởi tạo danh sách tại đây
    }

    // Getter cho artist
    public String getArtist() {
        return artist;
    }

    // --- CÁC PHƯƠNG THỨC QUẢN LÝ TRACK ---

    public void addTrack(Track track) {
        // Sau bài 15, contains() sẽ so sánh title và length của Track
        if (tracks.contains(track)) {
            System.out.println("Track '" + track.getTitle() + "' with length " + track.getLength() + " is already in the list.");
        } else {
            tracks.add(track);
            System.out.println("Added track: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Removed track: " + track.getTitle());
        } else {
            System.out.println("Track '" + track.getTitle() + "' not found.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // --- CÀI ĐẶT PHƯƠNG THỨC play() ---
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
        System.out.println("CD total length: " + this.getLength());
        System.out.println("--- List of Tracks ---");
        for (Track track : tracks) {
            track.play();
        }
    }
}