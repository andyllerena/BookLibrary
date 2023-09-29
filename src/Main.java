import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isAuthenticated = false;
        User currentUser = null;

        Library library = new Library();
        library.loadBooksFromFile("/Users/Andy/Desktop/Java/BookLibrary/src/Books");

        while (true) {
            System.out.println("Welcome to User Registration and Authentication System");

            if (!isAuthenticated) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");

                int authChoice = scanner.nextInt();

                switch (authChoice) {
                    case 1:
                        System.out.print("Enter username (email): ");
                        String newUsername = scanner.next();
                        System.out.print("Enter password: ");
                        String newPassword = scanner.next();
                        User.addUser(newUsername, newPassword);

                        // Automatically log in after successful registration
                        isAuthenticated = true;
                        currentUser = new User(newUsername, newPassword);

                        System.out.println("Registration successful!\n");
                        break;

                    case 2:
                        System.out.print("Enter username (email): ");
                        String username = scanner.next();
                        System.out.print("Enter password: ");
                        String password = scanner.next();

                        // Authenticate user
                        isAuthenticated = User.authenticate(username, password);

                        if (isAuthenticated) {
                            currentUser = new User(username, password);
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
            } else {
                System.out.println("Welcome, " + currentUser.getEmail() + "!");
                System.out.println("1. List Available Books");
                System.out.println("2. Logout");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Display available books
                        System.out.println("Available Books:");
                        library.displayBooks();
                        break;

                    case 2:
                        isAuthenticated = false;
                        currentUser = null;
                        System.out.println("Logout successful!\n");
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
}


