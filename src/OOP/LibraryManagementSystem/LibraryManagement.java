package OOP.LibraryManagementSystem;
import OOP.LibraryManagementSystem.models.Book;
import OOP.LibraryManagementSystem.models.Library;

import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {

        // Adding books, making objects
        Book book1 = new Book(1, "Electrical Circuits", "Saurav Phuyal", 200);
        Book book2 = new Book(2, "Africa", "Neshan Shrestha", 400);
        Book book3 = new Book(3, "Spiderman", "Peter Parker", 350);

        // Making new library and adding books made above
        Library horror = new Library(101);
        horror.addBook(book1);
        horror.addBook(book2);

        Library library2 = new Library(102);
        library2.addBook(book2);
        library2.addBook(book3);
        library2.addBook(book1);

        // Calling displaying books function from library class
        horror.displayAllBooks();
        library2.displayAllBooks();

    }
}
