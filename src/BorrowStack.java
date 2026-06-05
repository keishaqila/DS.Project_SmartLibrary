/*
    Carissa:
    wraps built-in Stack to track borrowing history in LIFO view
    called by SmartLibrary.borrowBook() and viewLatestHistory()
    main methods: push, pop, show, isEmpty
*/

import java.util.Stack;
public class BorrowStack {

    private final Stack<Book> stack = new Stack<>();

    // push = add borrowed book
    public void push(Book book) {
        if (book != null) {
            stack.push(book);
            System.out.println("Borrowed: " + book.getTitle());
        } else {
            System.out.println("Book not found!");
        }
    }

    // pop = remove last borrowed book (optional return feature)
    public Book pop() {
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return null;
    }

    // show = display borrowing history (LIFO order)
    public void show() {
        if (stack.isEmpty()) {
            System.out.println("No borrowing history.");
            return;
        }

        System.out.println("Borrowing History (Latest First): ");

        for (int i = stack.size() - 1; i >= 0; i--) {
            Book b = stack.get(i);

            System.out.println("ISBN: " + b.getIsbn() + ", Title: " + b.getTitle() + ", Author: " + b.getAuthor());
        }
    }

    // isEmpty = check stack status
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
