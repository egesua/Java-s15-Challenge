package com.workintech.library.person;

import com.workintech.library.books.Book;
import com.workintech.library.person.person_enum.Role;

import java.util.HashSet;
import java.util.Set;

public class Reader extends Person{
    private int bookLimit;
    private Set<Book> borrowed = new HashSet<>();
    private double payment;
    private double balance;
    public Reader(long id, String fullName) {
        super(id, fullName, Role.USER);
        this.bookLimit = 5;
    }

    public int getBookLimit() {
        return bookLimit;
    }

    public Set<Book> getBorrowed() {
        return borrowed;
    }

    public double getPayment() {
        return payment;
    }

    public double getBalance() {
        return balance;
    }

    public void setBookLimit(int bookLimit) {
        this.bookLimit = bookLimit;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
