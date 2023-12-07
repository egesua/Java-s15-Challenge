package com.workintech.library;


import java.util.HashSet;
import java.util.Set;

public class Book {
    private int bookId;
    private String author;
    private String name;
    private double price;
    private Status status;
    private String dateOfPurchase;

    public Book(int bookId, String author, String name, double price, Status status, String dateOfPurchase) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.dateOfPurchase = dateOfPurchase;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public static void main(String[] args) {
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book(1,"Mary Shelby","Frankenstein",14.99,Status.AVAILABLE,"31.03.1998"));
        bookSet.add(new Book(2,"Arthur C. Clarke","A Space Odyssey",20,Status.TAKEN,"03.01.2002"));
        bookSet.add(new Book(3,"Philip K. Dick","Blade Runner",12.99,Status.NOT_HAVE,"NaN"));
        bookSet.add(new Book(4,"Isaac Asimov","I, Robot",24.99,Status.AVAILABLE,"02.09.1995"));
        bookSet.add(new Book(5,"Ursula K. Le Guin","EarthSea",17.99,Status.TAKEN,"23.08.2002"));
        bookSet.add(new Book(6,"Isaac Asimov","Foundation",24.99,Status.AVAILABLE,"02.05.1998"));
    }

}
