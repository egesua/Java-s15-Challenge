package com.workintech.library.person;

import com.workintech.library.Library;
import com.workintech.library.books.Book;
import com.workintech.library.books.book_enums.Condition;
import com.workintech.library.interfaces.Customizable;
import com.workintech.library.person.person_enum.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Librarian extends Person implements Customizable {
    private String password;

    public Librarian(long id, String fullName, String password) {
        super(id, fullName, Role.LIBRARIAN);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void returnBook(List<Book> list, Book book) {
        if (list.contains(book)) {
            System.out.println("Book is already in the library.");
        } else {
            list.add(book);
            System.out.println("The book has been returned!");
        }
    }

    public Book searchBookByTitle(List<Book> list, String bookTitle) {
        for (Book book : list) {
            String title = book.getTitle();
            if (title.toLowerCase().contains(bookTitle.toLowerCase())) {
                System.out.println("The book has been found: " + book);
                return book;
            } else {
                System.out.println("We do not have the searched book in our library.");
            }
        }
        return null;
    }

    public Book searchById(List<Book> list, long bookId) {
        for (Book book : list) {
            long id = book.getId();
            if (id == bookId) {
                System.out.println("The book has been found: \n" + book);
                return book;
            } else {
                System.out.println("We could not found the book you have searched.");
            }
        }
        return null;
    }

    public void borrowBook(List<Book> list, Map<Book, Reader> borrow, Reader reader, Book book) {
        if (list.contains(book) && reader.getBookLimit() > 0) {
            reader.getBorrowed().add(book);
            borrow.put(book, reader);
            reader.setBookLimit(reader.getBookLimit());
            System.out.println(book.getTitle() + "has been borrowed by: " + reader.getFullName());
        } else {
            System.out.println("Already borrowed.");
        }
    }

    public void paymentReceiving(Book book, Reader reader) {
        reader.setPayment(book.getPrice());
        System.out.println("Your " + book.getPrice() + " has been paid.");
    }


    public Reader findReader(Set<Reader> readerSet, String readerName) {
        for (Reader reader : readerSet) {
            String readersName = reader.getFullName();
            if (readersName.toLowerCase().contains(readerName.toLowerCase())) {
                System.out.println("Searched reader is: " + reader);
                return reader;
            } else {
                System.out.println("There is no reader like this.");
            }
        }
        return null;
    }

    public Author findAuthor(Set<Author> authorSet, String authorName) {
        for (Author author : authorSet) {
            String authorsName = author.getFullName();
            if (authorsName.toLowerCase().contains(authorName.toLowerCase())) {
                System.out.println("Searched author is: " + author);
                return author;
            } else {
                System.out.println("There is no author like this.");
            }
        }
        return null;
    }

    public List<Book> getBookByAuthor(List<Book> bookList, String name) {
        List<Book> authorsBook = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().toLowerCase().contains(name.toLowerCase())) {
                authorsBook.add(book);
            }
        }
        return authorsBook;
    }

    public void refundToUser(Library library, Map<Book, Reader> borrow, Book book, Reader reader) {
        if (borrow.containsKey(book)) {
            System.out.println("Condition on the day " + getFullName() + " borrowed this book: " + book.getCondition());
            Condition updatedCondition = book.setCondition(Condition.randomCondition());
            System.out.println("");

            if (updatedCondition.equals(Condition.FACTORY_NEW)) {
                reader.setBalance(reader.getBalance());
                reader.setBookLimit(reader.getBookLimit() + 1);
                borrow.remove(book);
                library.getReturnedBooks().add(book);
                System.out.println("Your balance is: " + reader.getBalance());
            } else if (updatedCondition.equals(Condition.MINIMAL_WEAR)) {
                reader.setBalance(reader.getPayment() - ((reader.getPayment() / 5) * 4));
                double libraryCashBalance = library.getLibraryCashBalance();
                libraryCashBalance += ((reader.getPayment() / 5) * 4);
                reader.setBookLimit(reader.getBookLimit() + 1);
                borrow.remove(book);
                library.getReturnedBooks().add(book);
                System.out.println("Library total balance is: " + libraryCashBalance);
                System.out.println(reader.getFullName() + " your balance is: " + reader.getBalance());
            } else if (updatedCondition.equals(Condition.FIELD_TESTED)) {
                reader.setBalance(reader.getPayment() - ((reader.getPayment() / 5) * 3));
                double libraryCashBalance = library.getLibraryCashBalance();
                libraryCashBalance += ((reader.getPayment() / 5) * 3);
                reader.setBookLimit(reader.getBookLimit() + 1);
                borrow.remove(book);
                library.getReturnedBooks().add(book);
                System.out.println("Library total balance is: " + libraryCashBalance);
                System.out.println(reader.getFullName() + " your balance is: " + reader.getBalance());
            } else if (updatedCondition.equals(Condition.WELL_WORN)) {
                reader.setBalance(reader.getPayment() - ((reader.getPayment() / 5) * 2));
                double libraryCashBalance = library.getLibraryCashBalance();
                libraryCashBalance += ((reader.getPayment() / 5) * 2);
                borrow.remove(book);
                library.getReturnedBooks().add(book);
                System.out.println("Library total balance is: " + libraryCashBalance);
                System.out.println(reader.getFullName() + " your balance is: " + reader.getBalance());
            } else if (updatedCondition.equals(Condition.BATTLE_SCARRED)) {
                reader.setBalance(reader.getPayment() - (reader.getPayment() / 5));
                double libraryCashBalance = library.getLibraryCashBalance();
                libraryCashBalance += ((reader.getPayment() / 5) * 2);
                borrow.remove(book);
                library.getReturnedBooks().add(book);
                System.out.println("Library total balance is: " + libraryCashBalance);
                System.out.println(reader.getFullName() + " your balance is: " + reader.getBalance());
            } else {
                System.out.println("There is no book like this in our database.");
            }
        }

    }

    @Override
    public void newBook(List<Book> list, Book book) {
        if (list.contains(book)) {
            System.out.println("We already have this book in our inventory!");
        } else {
            list.add(book);
            System.out.println("Adding book to the library. Added: " + book);
        }
    }

    @Override
    public void deleteBook(List<Book> list, Book book) {
        if (list.contains(book)) {
            list.remove(book);
            System.out.println("Deleting the book from the library system. Deleting: " + book);
        } else {
            System.out.println("Can not execute. The book does not exist in the library.");
        }
    }

    @Override
    public void repriceBook(List<Book> list, Book book, double price) {
        if (list.contains(book)) {
            book.setPrice(price);
            System.out.println("The price has been raised!");
        } else {
            System.out.println("First we need the book for the price change!");
        }
    }

    @Override
    public void updateBook(List<Book> list, Book book, Condition condition) {
        if (list.contains(book)) {
            book.setCondition(condition);
            System.out.println("The status of the book has changed to: " + condition);
        } else {
            System.out.println("First we need to book for the status change!");
        }
    }
}
