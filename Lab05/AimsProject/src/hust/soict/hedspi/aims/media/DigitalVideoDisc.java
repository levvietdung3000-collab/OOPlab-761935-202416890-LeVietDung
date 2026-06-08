package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super(title);
        updateID();
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost, 0, null);
        updateID();
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost, 0, director);
        updateID();
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
        updateID();
    }

    private void updateID() {
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public String toString() {
        return "DVD - [" + this.getTitle() + "] - [" + this.getCategory() + "] - [" + 
               this.getDirector() + "] - [" + this.getLength() + "]: [" + this.getCost() + "] $";
    }

    public boolean isMatch(String searchTitle) {
        if (this.getTitle() == null || searchTitle == null) return false;
        return this.getTitle().toLowerCase().contains(searchTitle.toLowerCase());
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
