package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book() {

    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author '" + authorName + "' has been added successfully.");
        } else {
            System.out.println("Author '" + authorName + "' is already in the list!");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author '" + authorName + "' has been removed successfully.");
        } else {
            System.out.println("Author '" + authorName + "' is not present in the list!");
        }
    }
    @Override
    public String toString() {
        return "Book - [" + this.getTitle() + "] - [" + this.getCategory() + "] - Authors: " + authors + " - " + this.getCost() + " $";
    }
}