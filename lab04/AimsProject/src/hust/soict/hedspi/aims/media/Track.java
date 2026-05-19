package hust.soict.hedspi.aims.media;

import java.util.Objects;

public class Track implements Playable {
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    // Cập nhật equals theo yêu cầu bài 15
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        // Sử dụng instanceof để an toàn hơn khi so sánh
        if (!(obj instanceof Track)) return false;

        Track other = (Track) obj;

        // Trả về true nếu cả title và length đều khớp
        return this.length == other.length &&
                (this.title != null && this.title.equalsIgnoreCase(other.title));
    }

    // Nên thêm hashCode khi đã có equals
    @Override
    public int hashCode() {
        return Objects.hash(title != null ? title.toLowerCase() : null, length);
    }
}