package com.workintech.library.books;

import com.workintech.library.books.book_enums.BookGenre;
import com.workintech.library.books.book_enums.Condition;

public class Book {
    private long id;
    private String title;
    private String author;
    private double price;
    private Condition condition;
    private BookGenre genre;

    public Book(long id, String title, String author, double price, Condition condition, BookGenre genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.condition = condition;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Condition getCondition() {
        return condition;
    }

    public Condition setCondition(Condition condition) {
        this.condition = condition;
        return condition;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", status=" + condition +
                ", genre=" + genre +
                '}';
    }
}
