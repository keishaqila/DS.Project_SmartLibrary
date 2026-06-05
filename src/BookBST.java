public class BookBST {

    private Book root;

    // INSERT BOOK - Adds a new book into correct BST  position by ISBN
    public void insert(int isbn, String title, String author){
        root = in(root, isbn, title, author);
    }

    private Book in(Book node, int isbn, String title, String author) {
        if (node == null) return new Book(isbn, title, author);
        if (isbn < node.getIsbn())
            node.left = in(node.left, isbn, title, author);
        else if (isbn > node.getIsbn())
            node.right = in(node.right, isbn, title, author);
        return node;
    }

    // SEARCH A BOOK - Returns the book if found, null if not found
    public Book search (int isbn){
        return searching(root, isbn);
    }

    private Book searching(Book node,int isbn){
        if (node == null || node.getIsbn() == isbn) return node;
        return (isbn < node.getIsbn()) ? searching(node.left, isbn) : searching(node.right, isbn);
    }

    // REMOVES A BOOK - Removes the book from the BST and returns onto the BorrowStack.
    public Book remove(int isbn){
        Book target = search(isbn);
        if (target == null) return null;
        root = delete(root, isbn);
        return target;
    }

    private Book delete(Book node,int isbn){
        if (node == null) return null;

        if (isbn < node.getIsbn()) {
            node.left = delete(node.left, isbn);
        } else if (isbn > node.getIsbn()) {
            node.right = delete(node.right, isbn);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Book successor = findMin(node.right);
            node.right = delete(node.right, successor.getIsbn());
            Book newNode = new Book(successor.getIsbn(), successor.getTitle(), successor.getAuthor());
            newNode.left = node.left;
            newNode.right = node.right;
            return newNode;
        }
        return node;
    }

    private Book findMin(Book node){
        while (node.left != null) node = node.left;
        return node;
    }

    // DISPLAYS CATALOGUE OF BOOKS - Prints all books sorted by ISBN (in-order)
    public void catalogue() {
        if (root == null) {
            System.out.println("No books in catalogue.");
            return;
        }
        inOrder(root);
    }

    private void inOrder (Book node){
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node);
        inOrder(node.right);
    }
}

