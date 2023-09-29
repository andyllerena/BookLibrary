import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<String> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void loadBooksFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                books.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error loading books from file: " + e.getMessage());
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (String book : books) {
                System.out.println(book);
            }
        }
    }
}
