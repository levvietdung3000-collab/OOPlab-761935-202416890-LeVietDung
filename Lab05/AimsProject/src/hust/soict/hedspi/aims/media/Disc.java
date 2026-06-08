package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    public Disc() {
        super();
    }

    public Disc(String title) {
        super();
        this.setTitle(title);
    }

    public Disc(String title, String category, float cost, int length, String director) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.length = length;
        this.director = director;
    }

    // Getter methods
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}