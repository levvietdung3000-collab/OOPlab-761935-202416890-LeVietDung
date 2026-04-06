public class DigitalVideoDisc {
<<<<<<< HEAD
=======

>>>>>>> origin/topic/passing-parameters
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

<<<<<<< HEAD
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super();
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super();
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
=======

    public DigitalVideoDisc(String title) {
        this.title = title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }


    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
>>>>>>> origin/topic/passing-parameters
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
<<<<<<< HEAD
=======
// bài 9

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

>>>>>>> origin/topic/passing-parameters
}