package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tomfuller on 29/05/2017.
 */
public class BibliotecaAppTest {

    BibliotecaApp app = new BibliotecaApp();

    @Test
    public void testThatBibliotecaPrintsAWelcomeMessage() throws Exception {
        assertEquals("Hello, welcome to Biblioteca!", app.greet());
    }

    @Test
    public void checkThatBibliotecaPrintsABookList() throws Exception {
        assertEquals("Buttered Parsnips, Joe Lycett, 2016\nTest Driven Development, Kent Beck, 2003\nHead First Java, Kathy Sierra, 2005\n", app.printItemList("book"));
    }

    @Test
    public void checkThatMenuOptionOneIsListBooks() throws Exception {
        assertEquals("1. List books", app.menuOptions[0]);
    }

    @Test
    public void checkMenuOptionTwoIsQuit() throws Exception {
        assertEquals("2. Quit", app.menuOptions[1]);

    }

    @Test
    public void checkMenyOptionThreeIsCheckoutBook() throws Exception {
        assertEquals("3. Checkout Book", app.menuOptions[2]);
    }

    @Test
    public void checkedOutBookNoLongerInBookList() throws Exception {
        app.changeBookStatus("Buttered Parsnips", "checkout");
        assertEquals("Test Driven Development, Kent Beck, 2003\nHead First Java, Kathy Sierra, 2005\n", app.printItemList("book"));
    }

    @Test
    public void menuShowsReturnBook() throws Exception {
        assertEquals("4. Return Book", app.menuOptions[3]);
    }

    @Test
    public void returnedBookAppearsInList() throws Exception {
        app.changeBookStatus("Buttered Parsnips", "checkout");
        app.changeBookStatus("Buttered Parsnips", "return");
        assertEquals("Buttered Parsnips, Joe Lycett, 2016\nTest Driven Development, Kent Beck, 2003\nHead First Java, Kathy Sierra, 2005\n", app.printItemList("book"));
    }

    @Test
    public void successfulBookCheckoutMessage() throws Exception {
        assertEquals("Thank you! Enjoy the book", app.printMessage(true, "checkout"));
    }

    @Test
    public void unsuccessfulBookCheckoutMessage() throws Exception {
        assertEquals("That book is not available", app.printMessage(false, "checkout"));
    }

    @Test
    public void successfulBookReturnMessage() throws Exception {
        assertEquals("Thank you for returning the book.", app.printMessage(true, "return"));
    }

    @Test
    public void unsuccessfulBookReturnMessage() throws Exception {
        assertEquals("That is not a valid book to return.", app.printMessage(false, "return"));
    }

    @Test
    public void checkThatAMovieListIsPrinted() throws Exception {
        assertEquals("A Knights Tale, 2001, Brian Helgeland, 7\nDr Strange, 2016, Scott Derrickson, 8\n", app.printItemList("movie"));
    }

    @Test
    public void checkMenuOptionFiveIsListMovies() throws Exception {
        assertEquals("5. List Movies", app.menuOptions[4]);
    }
}