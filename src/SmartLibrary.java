import java.util.Scanner;

public class SmartLibrary implements LibraryADT {

    @Override
    public void addBook(int isbn, String title, String author) {}

    @Override
    public void searchBook(int isbn) {}

    @Override
    public void borrowBook(int isbn) {}

    @Override
    public void returnBook(int isbn) {}

    @Override
    public void viewLatestHistory() {}

    @Override
    public void viewCatalogue() {}

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

