package OOP.LibraryManagementSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private int libraryId;
    private List<Book> books;

    public Library(int libraryId) {
        this.libraryId = libraryId;
        this.books = new ArrayList<>();
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display total details of all books in the library
    public void displayAllBooks() {
        System.out.println("Library ID: " + libraryId);
        System.out.println("Books in the library:");

        for (Book book : books) {
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Price: $" + book.getPrice());
            System.out.println("--------------------------");
        }
    }

}
