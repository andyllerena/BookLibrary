public class Book {

    String title;
    String author;
    String genre;
    double price;
    boolean available;

    public Book(String title,String author, String genre, double price, boolean available){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.available = available;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }
}
