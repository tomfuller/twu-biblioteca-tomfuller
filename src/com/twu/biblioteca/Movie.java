package com.twu.biblioteca;

/**
 * Created by tomfuller on 01/06/2017.
 */
public class Movie extends Item {

    private String title;
    private int year;
    private String director;
    private String rating;

    public Movie(String movieName, int movieYear, String movieDirector, String movieRating) {
        title = movieName;
        year = movieYear;
        director = movieDirector;
        rating = movieRating;
    }

    public Movie(String movieName, int movieYear, String movieDirector) {
        this(movieName, movieYear, movieDirector, "Unrated");
    }

    public String getTitle() {
        return title;
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


    public String formatString() {
            return getTitle() + ", " + getYear() + ", " + getDirector() + ", " + getRating() + "\n";
        }


}
