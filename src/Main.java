import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in); // create a class Scanner
    static ArrayList<String> arrayList = new ArrayList<>(); // create an ArrayList

    public static void main(String[] args) {
        int option = 0;
        boolean erro = true;

        while (true) {
            try { // option menu
                System.out.println("------ Library ------");
                System.out.println("---------MENU--------");
                System.out.println("1 - Add book");
                System.out.println("2 - Remove book");
                System.out.println("3 - To edit book");
                System.out.println("4 - List books");
                System.out.println("5 - Search for a book");
                System.out.println("6 - Go out");

                if (sc.hasNextInt()) {
                    option = sc.nextInt();

                    // switch case to valide the option and leading the user for the method specific
                    switch (option) {
                        case 1:
                            addBook();
                            break;
                        case 2:
                            removeBook();
                            break;
                        case 3:
                            editBook();
                            break;
                        case 4:
                            listBook();
                            break;
                        case 5:
                            searchBook();
                            break;
                        case 6:
                            System.out.println("Leaving the Library!");
                            return;
                        default: // if the user not choose the option valide goes into here and come back to the loop
                            System.out.println("---------------------------------------");
                            System.out.println("Enter with a valid option to continue.");
                            System.out.println("---------------------------------------");
                    }
                } else { // if the user not choose the option valide goes into here and come back to the loop
                    System.out.println("---------------------------------");
                    System.out.println("Enter only valid numbers!");
                    System.out.println("---------------------------------");
                    sc.next();
                }

            } catch (InputMismatchException e) { // if the user not choose the option valide goes into here and come back to the loop
                System.out.println("---------------------------------");
                System.out.println("Enter only valid numbers!");
                System.out.println("---------------------------------");
                sc.next();
            }
        }
    }

    // method to add book
    public static void addBook(){
        String book;
        int choice;

        System.out.println("\nEnter with a name the book: ");
        sc.nextLine();
        book = sc.nextLine();

        arrayList.add(book); // add book in array
        System.out.println("\nBook add!");

        // checks if the user would like come back to menu or add another book
        System.out.println("\nWould you like to come back to the menu or add another book?" +
                "\n1 - Menu" +
                "\n2 - Add another book\n");
        choice = sc.nextInt();
        if (choice == 1){
            return;
        } else if (choice == 2) {
            addBook();
        }
    }

    // method the remove book
    public static void removeBook(){
        String book;
        int code = 0, choice = 0;

        // list of books before remove, showing the indexs the books
        System.out.println("List of Books:");
        for (String books: arrayList) {
            System.out.println(code + " - " + books);
            code += 1;
        }

        // ask to user the index for remove a book
        while (true){
            System.out.println("\nEnter with a code to remove a book: ");
            if (sc.hasNextInt()){
                sc.nextLine();
                code = sc.nextInt();
                arrayList.remove(code); // remove book in array
                break;
            }else {
                System.out.println("---------------------------------");
                System.out.println("Enter only valid numbers!");
                System.out.println("---------------------------------");
                sc.next();
            }
        }

        System.out.println("\nBook remove!");
        System.out.println("\nList after remove the book: \n");
        // list after the user remove book
        for (String books: arrayList) {
            System.out.println(code + " - " + books);
            code += 1;
        }

        // checks if the user would like come back to menu or remove another book
        System.out.println("\nWould you like to come back to the menu or remove another book?" +
                "\n1 - Menu" +
                "\n2 - Remove another book\n");
        choice = sc.nextInt();
        if (choice == 1){
            return;
        } else if (choice == 2) {
            removeBook();
        }
    }

    // method to list the books
    public static void listBook(){
        int choice = 0;

        // list the books
        System.out.println("List of Books:");
        for (String books: arrayList) {
            System.out.println(" - " + books);
        }

        // checks if the user would like come back to menu or list again
        System.out.println("\nWould you like to come back to the menu or list again?" +
                "\n1 - Menu" +
                "\n2 - List\n");
        choice = sc.nextInt();
        if (choice == 1){
            return;
        } else if (choice == 2) {
            listBook();
        }
    }

    // method to edit the book
    public static void editBook(){
        String newBook;
        int code = 0, choice = 0;

        // method the list the books before edit
        System.out.println("List of Books:");
        for (String books: arrayList) {
            System.out.println(code + " - " + books);
            code += 1;
        }

        while (true){
            System.out.println("\nEnter with a code to edit a book: ");
            if (sc.hasNextInt() || code < arrayList.size()){
                code = sc.nextInt();
                System.out.println("\nEnter with a new book: ");
                sc.nextLine();
                newBook = sc.nextLine();
                arrayList.set(code, newBook); // edit the book in array
                break;
            }else {
                System.out.println("---------------------------------");
                System.out.println("Enter only valid numbers!");
                System.out.println("---------------------------------");
                sc.next();
            }
        }

        System.out.println("\nBook edit!");
        // list after edit the book
        System.out.println("\nList after edit the book: \n");
        for (String books: arrayList) {
            System.out.println(code + " - " + books);
        }

        // checks if the user would like come back to menu or edit another book
        System.out.println("\nWould you like to come back to the menu or edit another book?" +
                "\n1 - Menu" +
                "\n2 - Edit another book\n");
        choice = sc.nextInt();
        if (choice == 1){
            return;
        } else if (choice == 2) {
            editBook();
        }
    }

    // method to search books
    public static void searchBook(){
        int code = 0, choice = 0;

        while(true) {
            System.out.println("\nEnter with a code to search a book: ");
            if (sc.hasNextInt() || code < arrayList.size()){
                code = sc.nextInt();
                // searching for the book in the array specific that the user enter
                System.out.println("\nBook: " + arrayList.get(code));
                break;
            }else {
                System.out.println("---------------------------------");
                System.out.println("Enter only valid numbers!");
                System.out.println("---------------------------------");
                sc.next();
            }
        }

        System.out.println("\nBook search!");
        // checks if the user would like come back to menu or search another book
        System.out.println("\nWould you like to come back to the menu or search another book?" +
                "\n1 - Menu" +
                "\n2 - Search another book\n");
        choice = sc.nextInt();
        if (choice == 1){
            return;
        } else if (choice == 2) {
            searchBook();
        }
    }
}