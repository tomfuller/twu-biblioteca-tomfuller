package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tomfuller on 29/05/2017.
 */
public class BibliotecaAppTest {

    BibliotecaApp app = new BibliotecaApp();
    Library library = new Library();

    @Test
    public void testThatBibliotecaPrintsAWelcomeMessage() throws Exception {
        assertEquals("Hello, welcome to Biblioteca!", app.greet());
    }

    @Test
    public void checkThatBibliotecaPrintsABookList() throws Exception {
        assertEquals("Buttered Parsnips, Joe Lycett, 2016\nTest Driven Development, Kent Beck, 2003\nHead First Java, Kathy Sierra, 2005\n", app.printItemList(app.library.bookArray));
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
        app.checkoutItem("Buttered Parsnips", app.library.bookArray);
        assertEquals("Test Driven Development, Kent Beck, 2003\nHead First Java, Kathy Sierra, 2005\n", app.printItemList(app.library.bookArray));
    }

    @Test
    public void menuShowsReturnBook() throws Exception {
        assertEquals("4. Return Book", app.menuOptions[3]);
    }

    @Test
    public void returnedBookAppearsInList() throws Exception {
        app.checkoutItem("Buttered Parsnips", app.library.bookArray);
        app.returnBook("Buttered Parsnips");
        assertEquals("Buttered Parsnips, Joe Lycett, 2016\nTest Driven Development, Kent Beck, 2003\nHead First Java, Kathy Sierra, 2005\n", app.printItemList(app.library.bookArray));
    }

    @Test
    public void successfulBookCheckoutMessage() throws Exception {
        assertEquals("Thank you! Enjoy the item", app.checkoutMessages(true));
    }

    @Test
    public void unsuccessfulBookCheckoutMessage() throws Exception {
        assertEquals("That item is not available", app.checkoutMessages(false));
    }

    @Test
    public void successfulBookReturnMessage() throws Exception {
        assertEquals("Thank you for returning the book.", app.returnMessages(true));
    }

    @Test
    public void unsuccessfulBookReturnMessage() throws Exception {
        assertEquals("That is not a valid book to return.", app.returnMessages(false));
    }

    @Test
    public void checkThatAMovieListIsPrinted() throws Exception {
        assertEquals("A Knights Tale, 2001, Brian Helgeland, 7\nDr Strange, 2016, Scott Derrickson, 8\n", app.printItemList(app.library.movieArray));
    }

    @Test
    public void checkMenuOptionFiveIsListMovies() throws Exception {
        assertEquals("5. List Movies", app.menuOptions[4]);
    }

    @Test
    public void checkMenuOptionSixIsCheckoutMovie() throws Exception {
        assertEquals("6. Checkout Movie", app.menuOptions[5]);
    }

    @Test
    public void checkedOutMovieIsNoLongerInList() throws Exception {
        app.checkoutItem("A Knights Tale", app.library.movieArray);
        assertEquals("Dr Strange, 2016, Scott Derrickson, 8\n", app.printItemList(app.library.movieArray));
    }

    @Test
    public void currentUserShouldBeTheUserWhoLoggedInMostRecently() throws Exception {
        app.userLogIn("123-1234", "lemmein");
        assertEquals(app.users[0], app.getCurrentUser());
    }

    @Test
    public void whenUserIsLoggedInCanPrintUserDetails() throws Exception {
        app.userLogIn("123-1234", "lemmein");
        assertEquals( app.users[0], app.getCurrentUser());
    }
}