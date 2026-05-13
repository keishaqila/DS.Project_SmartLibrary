import java.util.Scanner;

public class SmartLibrary implements LibraryADT {
    /*
    Ahdys:
    - implement from LibraryADT and fill inside methods
    Member:
    - console menu: runmenu, printmenu, handlechoice (like a remote to choose from menu)
     */

 @Override
    public void addBook(int isbn, String title, String author) {}

    @Override
    public void searchBook(int isbn) {}

    @Override
    public void borrowBook(int isbn) {}

    @Override
    public void viewLatestHistory() {}

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

            if (choice == 5) break;

            handleChoice(choice, sc);
        }

        sc.close();
    }

    private void printMenu() {
        System.out.println("\n--- SmartLibrary Menu ---");
        System.out.println("1. Add Book");
        System.out.println("2. Search Book (BST)");
        System.out.println("3. Borrow Book (Stack)");
        System.out.println("4. View History");
        System.out.println("5. Exit");
    }

    private void handleChoice(int choice, Scanner sc) {
        switch (choice) {
            case 1:
                System.out.print("Enter ISBN: ");
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
                searchBook(sc.nextInt());
                break;

            case 3:
                System.out.print("Enter ISBN to borrow: ");
                borrowBook(sc.nextInt());
                break;

            case 4:
                viewLatestHistory();
                break;

            default:
                System.out.println("Invalid option. Please choose between 1-5.");
        }
    }
}

