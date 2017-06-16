package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tomfuller on 29/05/2017.
 */
public class BookTest {

    Book book = new Book("Buttered Parsnips", "Joe Lycett", 2016);


    @Test
    public void bookInitializeWithTitle() throws Exception {
        assertEquals("Failure - book title doesn't match", "Buttered Parsnips", book.getTitle());
    }

    @Test
    public void bookInitializedWithAuthor() throws Exception {
        assertEquals("Joe Lycett", book.getAuthor());
    }

    @Test
    public void bookInitializeWithYearPublished() throws Exception {
        assertEquals(2016, book.getYearPublished());
    }

    @Test
    public void bookShouldBeInitialisedNotCheckedOut() throws Exception {
        assertEquals(false, book.isCheckedOut);
    }

    @Test
    public void bookShouldBeMarkedCheckedOutWhenBookHasBeenCheckedOut() throws Exception {
        book.checkOut();
        assertEquals(true, book.isCheckedOut);
    }

    @Test
    public void bookShouldBeMarkedNotCheckedOutWhenBookHasBeenReturned() throws Exception {
        book.checkOut();
        book.returnBook();
        assertEquals(false, book.isCheckedOut);
    }
}