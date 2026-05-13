public class Book {
    private int isbn;
    private String title, author;
    private boolean isAvailable;
    Book left,right;

    public Book(int isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getIsbn() {return isbn;}
    public void setIsbn(int isbn) {this.isbn = isbn;}

    public String getAuthor() {return author;}
    public void setAuthor(String author){this.author = author;}

    public String getTitle() {return title;}
    public void setTitle(String title){this.title = title;}

    public boolean isAvailable() {return isAvailable;}
    public void setAvailable(boolean available) {this.isAvailable = available;}

    public String toString(){
        return "[ISBN: " + isbn + "] \"" + title + "\" by " + author;
    }
}
