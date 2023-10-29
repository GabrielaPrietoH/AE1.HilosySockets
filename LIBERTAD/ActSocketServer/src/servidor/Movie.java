package servidor;

public class Movie {
    private int ID;
    private double price;
    private String title = null;
    private String director = null; 

    public Movie(int id, String title, String director, double price){
        this.ID = id;
        this.title = title;
        this.director = director;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie [ID=" + ID + ", price=" + price + ", title=" + title + ", director=" + director + "]";
    }
}