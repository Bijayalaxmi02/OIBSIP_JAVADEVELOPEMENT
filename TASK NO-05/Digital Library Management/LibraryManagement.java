import java.util.*;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued = false;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}

public class LibraryManagement {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();

    // Default Login Credentials
    static String adminUsername = "admin";
    static String adminPassword = "admin123";

    static String userUsername = "user";
    static String userPassword = "user123";

    public static void main(String[] args) {

        // Sample Books
        books.add(new Book(101, "Java Programming", "James Gosling"));
        books.add(new Book(102, "Data Structures", "Robert Lafore"));
        books.add(new Book(103, "Operating System", "Galvin"));

        login();
    }

    static void login() {
        System.out.println("\n===== DIGITAL LIBRARY SYSTEM =====");
        System.out.println("1) Admin Login");
        System.out.println("2) User Login");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        if (choice == 1) adminLogin();
        else if (choice == 2) userLogin();
        else {
            System.out.println("Invalid Choice!");
            login();
        }
    }

    // ---------------- ADMIN SECTION ----------------

    static void adminLogin() {
        System.out.print("\nEnter Admin Username: ");
        String u = sc.next();
        System.out.print("Enter Password: ");
        String p = sc.next();

        if (u.equals(adminUsername) && p.equals(adminPassword)) {
            System.out.println("\n✔ Admin Logged In Successfully!");
            adminMenu();
        } else {
            System.out.println("❌ Incorrect Login! Try Again.");
            adminLogin();
        }
    }

    static void adminMenu() {
        System.out.println("\n===== ADMIN MENU =====");
        System.out.println("1) Add Book");
        System.out.println("2) Delete Book");
        System.out.println("3) Update Book Details");
        System.out.println("4) View All Books");
        System.out.println("5) Logout");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> addBook();
            case 2 -> deleteBook();
            case 3 -> updateBook();
            case 4 -> viewBooks();
            case 5 -> login();
            default -> adminMenu();
        }
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("✔ Book Added Successfully!");
        adminMenu();
    }

    static void deleteBook() {
        System.out.print("Enter Book ID to Delete: ");
        int id = sc.nextInt();

        books.removeIf(b -> b.id == id);
        System.out.println("✔ Book Deleted Successfully!");
        adminMenu();
    }

    static void updateBook() {
        System.out.print("Enter Book ID to Update: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                sc.nextLine();
                System.out.print("Enter New Title: ");
                b.title = sc.nextLine();
                System.out.print("Enter New Author: ");
                b.author = sc.nextLine();
                System.out.println("✔ Book Updated!");
                adminMenu();
                return;
            }
        }
        System.out.println("❌ Book Not Found!");
        adminMenu();
    }

    // ---------------- USER SECTION ----------------

    static void userLogin() {
        System.out.print("\nEnter Username: ");
        String u = sc.next();
        System.out.print("Enter Password: ");
        String p = sc.next();

        if (u.equals(userUsername) && p.equals(userPassword)) {
            System.out.println("\n✔ User Logged In Successfully!");
            userMenu();
        } else {
            System.out.println("❌ Incorrect Login!");
            userLogin();
        }
    }

    static void userMenu() {
        System.out.println("\n===== USER MENU =====");
        System.out.println("1) View Books");
        System.out.println("2) Search Book");
        System.out.println("3) Issue Book");
        System.out.println("4) Return Book");
        System.out.println("5) Logout");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> viewBooks();
            case 2 -> searchBook();
            case 3 -> issueBook();
            case 4 -> returnBook();
            case 5 -> login();
            default -> userMenu();
        }
    }

    static void viewBooks() {
        System.out.println("\n===== AVAILABLE BOOKS =====");
        for (Book b : books) {
            System.out.println(b.id + " | " + b.title + " | " + b.author + " | " + (b.isIssued ? "❌ Issued" : "✔ Available"));
        }
    }

    static void searchBook() {
        System.out.print("\nEnter Book Title to Search: ");
        sc.nextLine();
        String title = sc.nextLine();

        for (Book b : books) {
            if (b.title.toLowerCase().contains(title.toLowerCase())) {
                System.out.println("\nFOUND: " + b.id + " | " + b.title + " | " + b.author);
                return;
            }
        }
        System.out.println("❌ Book Not Found!");
    }

    static void issueBook() {
        System.out.print("Enter Book ID to Issue: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id && !b.isIssued) {
                b.isIssued = true;
                System.out.println("✔ Book Issued Successfully!");
                return;
            }
        }
        System.out.println("❌ Book Not Available!");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to Return: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id && b.isIssued) {
                b.isIssued = false;
                System.out.println("✔ Book Returned Successfully!");
                return;
            }
        }
        System.out.println("❌ Invalid Return Request!");
    }
}
