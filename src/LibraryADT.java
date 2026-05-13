public interface LibraryADT {
    /*
     Ahdys:
     Add methods for adding, searching, borrowing, and returning books
     Add method to display catalogue and latest history
     */

    void addBook(int isbn, String title, String author);
    void searchBook(int isbn);
    void borrowBook(int isbn);
    void viewLatestHistory();


}
