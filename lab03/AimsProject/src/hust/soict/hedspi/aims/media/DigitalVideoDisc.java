package hust.soict.hedspi.aims.media;

// Lớp này kế thừa Disc (đã bao gồm id, title, category, cost, director, length)
public class DigitalVideoDisc extends Disc implements Playable {

    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, null, 0.0f, null, 0);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, null, 0);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, director, 0);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, director, length);
    }

    // --- CÀI ĐẶT PHƯƠNG THỨC play() ---
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    // --- CÁC PHƯƠNG THỨC BỔ TRỢ ---

    // Chú ý: Không thêm bất kỳ hàm setDirector hay setLength nào ở đây
    // theo yêu cầu "Remove redundant setter methods".

    public boolean isMatch(String title) {
        if (this.getTitle() == null) return false;
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public String toString() {
        return "DVD [ID=" + getId() + "] - " + getTitle() + " - "
                + (getCategory() != null ? getCategory() : "N/A") + " - "
                + (getDirector() != null ? getDirector() : "N/A") + " - "
                + getLength() + " min: " + getCost() + " $";
    }
}