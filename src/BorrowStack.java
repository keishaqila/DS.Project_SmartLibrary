
    /*
    Carissa:
    wraps built-in ( using) Stack to track borrowing history in LIFO view
    called by SmartLibrary.borrowBook() and viewLatestHistory()
    * main methods: push, pop, show, isEmpty
     */
    import java.util.Stack;

/*
    Carissa:
    wraps built-in Stack to track borrowing history in LIFO view
    called by SmartLibrary.borrowBook() and viewLatestHistory()
    main methods: push, pop, show, isEmpty
*/

    public class BorrowStack {

        private Stack<Book> stack = new Stack<>();

        // push = add borrowed book
        public void push(Book book) {
            if (book != null) {
                stack.push(book);
                System.out.println("Borrowed: " + book.title);
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

            System.out.println("\nBorrowing History (Latest First):");

            for (int i = stack.size() - 1; i >= 0; i--) {
                Book b = stack.get(i);

                System.out.println("ISBN: " + b.isbn + ", Title: " + b.title + ", Author: " + b.author);
            }
        }

        // isEmpty = check stack status
        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

}
