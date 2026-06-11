public class BookBST {

    private Book root;

    // INSERT BOOK - Adds a new book into correct BST  position by ISBN
    public void insert(int isbn, String title, String author){
        root = ins(root, isbn, title, author);
    }

    // Helper method used to compare ISBNs for book insertion.
    private Book ins(Book node, int isbn, String title, String author) {
        // Base book: If it is a null point, create an insertion point here.
        if (node == null) return new Book(isbn, title, author);

        // If the new ISBN is smaller, recursively traverses down the left subtree.
        if (isbn < node.getIsbn())
            node.left = ins(node.left, isbn, title, author);

        // If the new ISBN is larger, recursively traverses down the right subtree.
        else if (isbn > node.getIsbn())
            node.right = ins(node.right, isbn, title, author);
        return node;
    }

    // SEARCH A BOOK - Locates a book using its unique ISBN.
    public Book search (int isbn){
        return sea(root, isbn);
    }

    // Helper method used to achieve O(log n) search efficiency
    private Book sea(Book node,int isbn){
        // stops if the book is found or doesn't exist
        if (node == null || node.getIsbn() == isbn) return node;

        // Ternary condition: If target isbn is smaller, go to left subtree. If not, go to the right.
        return (isbn < node.getIsbn()) ? sea(node.left, isbn) : sea(node.right, isbn);
    }

    // Displays catalogue of all books in order from smallest to greatest ISBN value.
    public void catalogue() {
        if (root == null) {
            System.out.println("No books in catalogue.");
            return;
        }
        inOrder(root);
    }

    // In-Order Traversal (Left -> Root -> Right)
    private void inOrder (Book node){
        if (node == null) return;
        inOrder(node.left);         // Visits all SMALLER items in left subtree
        System.out.println(node);   // Print the current parent book node
        inOrder(node.right);        // Visits all GREATER items in right subtree
    }
}