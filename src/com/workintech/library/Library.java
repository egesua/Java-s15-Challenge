package com.workintech.library;

import com.workintech.library.books.Book;
import com.workintech.library.person.Author;
import com.workintech.library.person.Librarian;
import com.workintech.library.person.Person;
import com.workintech.library.person.Reader;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Library {
    private List<Book> books;
    private Set<Reader> readers;
    private Set<Author> authors;
    private Map<Book, Reader> booksBorrowed;
    private List<Book> returnedBooks;
    private Librarian librarian;
    private double libraryCashBalance;

    public Library(List<Book> books, Set<Reader> readers, Set<Author> authors,
                   Map<Book, Reader> booksBorrowed, List<Book> returnedBooks,
                   Librarian librarian) {
        this.books = books;
        this.readers = readers;
        this.authors = authors;
        this.booksBorrowed = booksBorrowed;
        this.returnedBooks = returnedBooks;
        this.librarian = librarian;
        this.libraryCashBalance = 1000;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Set<Reader> getReaders() {
        return readers;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public Map<Book, Reader> getBooksBorrowed() {
        return booksBorrowed;
    }

    public List<Book> getReturnedBooks() {
        return returnedBooks;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public double getLibraryCashBalance() {
        return libraryCashBalance;
    }

    public boolean checkPassword(Person person, String password) {
        if (person instanceof Librarian) {
            if (((Librarian) person).getPassword().toLowerCase().equalsIgnoreCase(password)) {
                return true;
            } else return false;
        } else if (person instanceof Author) {
            if (((Author) person).getPassword().toLowerCase().equalsIgnoreCase(password)) {
                return true;
            } else return false;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", readers=" + readers +
                ", authors=" + authors +
                ", booksBorrowed=" + booksBorrowed +
                ", returnedBooks=" + returnedBooks +
                ", librarian=" + librarian +
                ", libraryCashBalance=" + libraryCashBalance +
                '}';
    }
}
