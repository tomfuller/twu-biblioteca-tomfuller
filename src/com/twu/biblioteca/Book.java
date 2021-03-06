package com.twu.biblioteca;

/**
 * Created by tomfuller on 29/05/2017.
 */
public class Book extends Item {

    private String title;
    private String author;
    private int yearPublished;

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

    public void returnBook() {
        isCheckedOut = false;
    }

    public String formatString() {
       return getTitle() + ", " + getAuthor() + ", " + getYearPublished() + "\n";
    }


}
