package com.twu.biblioteca;

/**
 * Created by tomfuller on 01/06/2017.
 */
public class Movie {

    private String name;
    private int year;
    private String director;
    private String rating;

    public Movie(String movieName, int movieYear, String movieDirector, String movieRating) {
        name = movieName;
        year = movieYear;
        director = movieDirector;
        rating = movieRating;
    }

    public Movie(String movieName, int movieYear, String movieDirector) {
        this(movieName, movieYear, movieDirector, "Unrated");
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }
}
