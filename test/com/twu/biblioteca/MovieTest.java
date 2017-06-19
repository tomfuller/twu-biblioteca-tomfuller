package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tomfuller on 01/06/2017.
 */
public class MovieTest {

    Movie movie = new Movie("A Knights Tale", 2001, "Brian Helgeland", "8");

    @Test
    public void getMovieName() throws Exception {
        assertEquals("A Knights Tale", movie.getTitle());
    }

    @Test
    public void getMovieYear() throws Exception {
        assertEquals(2001, movie.getYear());
    }


    @Test
    public void getMovieDirector() throws Exception {
        assertEquals("Brian Helgeland", movie.getDirector());
    }


    @Test
    public void getMovieRating() throws Exception {
        assertEquals("8", movie.getRating());
    }

    @Test
    public void createUnratedMovie() throws Exception {
        Movie unrated = new Movie("A Knights Tale", 2001, "Brian Helgeland");
        assertEquals("Unrated", unrated.getRating());
    }

    @Test
    public void checkoutMovieShouldChangeMovieStateToCheckedout() throws Exception {
        movie.checkOut();
        assertEquals(true, movie.isCheckedOut);
    }
}