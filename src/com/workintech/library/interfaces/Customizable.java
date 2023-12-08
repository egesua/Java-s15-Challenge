package com.workintech.library.interfaces;

import com.workintech.library.books.Book;
import com.workintech.library.books.book_enums.Condition;

import java.util.List;

public interface Customizable {
    void newBook(List<Book> list, Book book);
    void deleteBook(List<Book> list, Book book);
    void repriceBook(List<Book> list, Book book, double price);
    void updateBook(List<Book> list, Book book, Condition condition);
}
