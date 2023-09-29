import java.util.Scanner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Library library = new Library();
        library.readTextFile("Books");


        while (true) {
            System.out.println("Welcome to User Registration and Authentication System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String newUsername = scanner.next();
                    System.out.print("Enter password: ");
                    String newPassword = scanner.next();
                    User.addUser(newUsername, newPassword);
                    System.out.println("Registration successful!\n");
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();

                    if (User.authenticate(username, password)) {
                        System.out.println("Login successful!\n");
                    } else {
                        System.out.println("Login failed. Invalid username or password.\n");
                    }
                    break;

                case 3:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        }
    }
}
