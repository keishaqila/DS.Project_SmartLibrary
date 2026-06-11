//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Loading up The Library System..");

        try {
            SmartLibrary library = new SmartLibrary();
            //using LibraryADT interface here to follow info hiding requirement

            library.runMenu();
            //cast to SmartLibrary to access the runmenu helper method

        } catch (Exception e) {
            //catching exception plus grading requirement

            System.err.println("\nA system error occurred: " + e.getMessage());
            System.err.println("Saving System Data and exiting");
        } finally {
            System.out.println("\nThanks for using our Smart Library System. Goodbye!! :D");
        }
    }
}