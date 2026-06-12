import java.util.Scanner;
import java.io.*;

public class SmartLibrary implements LibraryADT {

    private static final String Book_File = "books.txt";

    private final BookBST catalogue;
    private final BorrowStack history;

    public SmartLibrary() {
        this.catalogue = new BookBST();
        this.history = new BorrowStack();

        loadBooksFromFile();
    }

    private void loadBooksFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(Book_File))) {
            String line;
            while ((line = br.readLine()) != null){
                String[] books = line.split(",");
                if (books.length == 3){
                    int isbn = Integer.parseInt(books[0].trim());
                    String title = books[1].trim();
                    String author = books[2].trim();

                    catalogue.insert(isbn, title, author);
                }
            }
            System.out.println("Successfully loaded from " + Book_File);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Notice: Could not read initialization file. Starting with an empty catalogue.");
        }
    }

    @Override
    public void addBook(int isbn, String title, String author) {
        catalogue.insert(isbn, title, author);
        System.out.println("Successfully added: \"" + title + "\" to the catalogue.");
    }

    @Override
    public void searchBook(int isbn) {
        Book foundBook = catalogue.search(isbn);
        if (foundBook != null) {
            System.out.println("Book Found! -> " + foundBook);
            System.out.println("Availability: " + (foundBook.isAvailable() ? "Available" : "Checked Out"));
        } else {
            System.out.println("Error: Book with ISBN " + isbn + " not found in the catalogue.");
        }
    }

    @Override
    public void borrowBook(int isbn) {
        Book targetBook = catalogue.search(isbn);

        if (targetBook == null) {
            System.out.println("Error: Book with ISBN " + isbn + " does not exist.");
            return;
        }
        if (!targetBook.isAvailable()) {
            System.out.println("Sorry, \"" + targetBook.getTitle() + "\" is already borrowed.");
            return;
        }
        targetBook.setAvailable(false);
        history.push(targetBook);
    }

    @Override
    public void returnBook(int isbn) {
        Book targetBook = catalogue.search(isbn);

        if (targetBook == null) {
            System.out.println("Error: This book does not belong to our library catalogue.");
            return;
        }
        if (targetBook.isAvailable()) {
            System.out.println("This book is already sitting in the library catalogue.");
            return;
        }
        // fallback just in case they return books out of order
        targetBook.setAvailable(true);
        System.out.println("Successfully returned: \"" + targetBook.getTitle() + "\" (History updated)");
    }

    @Override
    public void viewLatestHistory() {
        history.show();
    }

    @Override
    public void viewCatalogue() {
        System.out.println("\n- Current Library Catalogue (Sorted by ISBN) -");
        catalogue.catalogue();
        System.out.println("_________________________________________________");
    }

    public void runMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.print("Choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();
            if (choice == 7) break;
            handleChoice(choice, sc);
        }

        sc.close();
    }

    private void printMenu() {
        System.out.println("|====================|");
        System.out.println("| Smart Library Menu |");
        System.out.println("|====================|");
        System.out.println("| 1. Add Book        |");
        System.out.println("| 2. Search Book     |");
        System.out.println("| 3. Borrow Book     |");
        System.out.println("| 4. Return Book     |");
        System.out.println("| 5. View History    |");
        System.out.println("| 6. View Catalogue  |");
        System.out.println("| 7. Exit            |");
        System.out.println("|====================|");
    }

    private void handleChoice(int choice, Scanner sc) {
        switch (choice) {
            case 1:
                System.out.print("Enter ISBN: ");
                if (!sc.hasNextInt()){
                    System.out.println("Invalid ISBN. Must be a number.");
                    sc.next();
                    break;
                }
                int isbn = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Title: ");
                String title = sc.nextLine();

                System.out.print("Enter Author: ");
                String author = sc.nextLine();

                addBook(isbn, title, author);
                break;

            case 2:
                System.out.print("Enter ISBN to search: ");
                if (!sc.hasNextInt()){
                    System.out.println("Invalid ISBN.");
                    sc.next();
                    break;
                }
                searchBook(sc.nextInt());
                break;

            case 3:
                System.out.print("Enter ISBN to borrow: ");
                if (!sc.hasNextInt()){
                    System.out.println("Invalid ISBN.");
                    sc.next();
                    break;
                }
                borrowBook(sc.nextInt());
                break;
            case 4:
                System.out.print("Enter ISBN to return: ");
                if (!sc.hasNextInt()){
                    System.out.println("Invalid ISBN.");
                    sc.next();
                    break;
                }
                returnBook(sc.nextInt());
                break;

            case 5:
                viewLatestHistory();
                break;

            case 6:
                viewCatalogue();
                break;

            default:
                System.out.println("Invalid option. Please choose between 1-7.");
        }
    }
}

