package com.twu.biblioteca;

/**
 * Created by tomfuller on 19/06/2017.
 */
public class Library {

    Book butteredParsnips = new Book("Buttered Parsnips", "Joe Lycett", 2016);
    Book testDrivenDevelopment = new Book("Test Driven Development", "Kent Beck", 2003);
    Book headFirstJava = new Book("Head First Java", "Kathy Sierra", 2005);
    Book[] bookArray = {butteredParsnips, testDrivenDevelopment, headFirstJava};

    Movie aKnightsTale = new Movie("A Knights Tale", 2001, "Brian Helgeland", "7");
    Movie drStrange = new Movie("Dr Strange", 2016, "Scott Derrickson", "8");
    Movie[] movieArray = {aKnightsTale, drStrange};

}
