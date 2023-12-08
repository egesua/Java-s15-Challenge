package com.workintech.library.person;

import com.workintech.library.books.Book;
import com.workintech.library.books.book_enums.Condition;
import com.workintech.library.interfaces.Customizable;
import com.workintech.library.person.person_enum.Role;

import java.util.List;

public final class Author extends Person implements Customizable {
    String password;

    public Author(long id, String fullName, Role role, String password) {
        super(id, fullName, role);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void newBook(List<Book> list, Book book) {
        if(list.contains(book)){
            System.out.println("We already have this book in our inventory!");
        } else {
            list.add(book);
            System.out.println("Adding book to the library. Added: " + book);
        }
    }

    @Override
    public void deleteBook(List<Book> list, Book book) {
        if(list.contains(book)){
            list.remove(book);
            System.out.println("Deleting the book from the library system. Deleting: " + book);
        } else {
            System.out.println("Can not execute. The book does not exist in the library.");
        }
    }

    @Override
    public void repriceBook(List<Book> list, Book book, double price) {
        if(list.contains(book)){
            book.setPrice(price);
            System.out.println("The price has been raised!");
        } else {
            System.out.println("First we need the book for the price change!");
        }
    }

    @Override
    public void updateBook(List<Book> list, Book book, Condition condition) {
        if(list.contains(book)) {
            book.setCondition(condition);
            System.out.println("The status of the book has changed to: " + condition);
        } else {
            System.out.println("First we need to book for the status change!");
        }
    }
}
