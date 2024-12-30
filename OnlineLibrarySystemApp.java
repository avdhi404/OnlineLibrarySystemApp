import java.util.Scanner; // Import Scanner for user input
import java.util.ArrayList; // Import ArrayList to store books

// Book class represents each book in the library
class Book {
    String title;
    String author;
    boolean isAvailable;

    // Constructor to initialize a book
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // Books are available when added
    }

    // Display book details
    public void displayBook() {
        System.out.println("Title: " + title + " | Author: " + author + " | Available: " + (isAvailable ? "Yes" : "No"));
    }

    // Check out the book
    public void checkOutBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully checked out '" + title + "' by " + author + ".");
        } else {
            System.out.println("Sorry, the book '" + title + "' is not available.");
        }
    }

    // Return the book
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("You have successfully returned '" + title + "' by " + author + ".");
        } else {
            System.out.println("This book was not checked out.");
        }
    }
}

// Library class manages the book collection
class Library {
    ArrayList<Book> books = new ArrayList<>(); // Store books in an ArrayList

    // Add books to the library
    public void addBooks() {
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("Moby-Dick", "Herman Melville"));
    }

    // Display all available books
    public void displayAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        for (Book book : books) {
            book.displayBook();
        }
    }

    // Check out a book
    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                book.checkOutBook();
                return;
            }
        }
        System.out.println("Sorry, no such book found.");
    }

    // Return a book
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Sorry, no such book found.");
    }
}

// Main application class
public class OnlineLibrarySystemApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        Library library = new Library(); // Create library instance
        library.addBooks(); // Add books to the library

        while (true) {
            // Display menu
            System.out.println("\n--- Online Library System ---");
            System.out.println("1. View Available Books");
            System.out.println("2. Check Out a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: // View available books
                    library.displayAvailableBooks();
                    break;
                case 2: // Check out a book
                    System.out.print("Enter the title of the book to check out: ");
                    String checkOutTitle = scanner.nextLine();
                    library.checkOutBook(checkOutTitle);
                    break;
                case 3: // Return a book
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 4: // Exit the program
                    System.out.println("Thank you for using the Online Library System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
