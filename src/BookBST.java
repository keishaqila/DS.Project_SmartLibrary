public class BookBST {
    /*
    Keisha:
    * Insert:
        called by SmartLibrary.addBook
        - add a new book into the correct BST position by ISBN.
    * Search:
        called by SmartLibrary.searchBook() and borrowBook()
        - returns the Book if found, null if not found.
    * Delete:
        called by SmartLibrary.borrowBook()
        - Removes the book from the BST and returns onto the BorrowStack.
    *  Catalogue:
        called by SmartLibrary.viewCatalogue()
        - prints all books sorted by ISBN
    */

    private Book root;

    // Adds a new book into correct BST  possition by ISBN
    public void insert(int isbn, String title, String author){
        book = ins(root, isbn, title, author);
    }

    private Book ins(Book node, int isbn, String title, String author){
        if (node == null) return new Book(isbn, title, author);
        if (isbn < node.getIsbn())
            node.left = ins(node.left, isbn, title, author);
        else if (isbn > node.getIsbn()){
            node.right = ins(node.right, isbn, title, author);
        return node;
    }

    // Returns the Book if found, null if not found
    public Book search(int isbn){
        return sea(root, isbn);
    }

    private Book sea(Book node, int isbn){
        if (node == null || node.getIsbn() == isbn) return node;
        return (isbn < node.getIsbn)? sea(node.left, isbn) : sea(node.right, isbn);
    }

    // Removes the book from the BST and returns onto the BorrowStack.
    public void remove(int isbn){
        Book target = search(isbn);
        if (target == null) return null;
        root = del(root, isbn);
        return target;
    }

    private Book del(Book node, int isbn){
        if (node == null) return null;

        if (isbn < node.getIsbn()){
            node.left = del(node.left, isbn);
        } else if (isbn > node.getIsbn()){
            node.right = del(node.roght, isbn)
        } else {
            if (node.left  == null) return node.right;
            if (node.right == null) return node.left;

            Book successor = findMin(node.right);
            node.right = del(node.right, successor.getIsbn())
            successor.left = node.left;
            successor.right = node.right;
            return successor;
        }
        return node;
    }

    private Book findMin(Book node){
        while (node.left != null) node=node.left;
        return node;
    }

    // prints all books sorted by ISBN (in-order)
    public void catalogue(){
        if (root == null) {
            System.out.println("No books in catalogue.");
            return;
        }
        inOrder(root);
    }

    private void inOrder(Book node){
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node);
        inOrder(node.right);
    }
}
