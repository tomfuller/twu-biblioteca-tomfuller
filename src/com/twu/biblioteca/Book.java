package com.twu.biblioteca;

/**
 * Created by tomfuller on 29/05/2017.
 */
public class Book {

    private String title;
    private String author;
    private int yearPublished;
    public boolean isCheckedOut = false;

    public Book(String bookTitle, String bookAuthor, int bookYearPublished) {
        title = bookTitle;
        author = bookAuthor;
        yearPublished = bookYearPublished;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void checkOut() {
        isCheckedOut = true;
    }

    public void returnBook() {
        isCheckedOut = false;
    }
}
