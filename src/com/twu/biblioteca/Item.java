package com.twu.biblioteca;

/**
 * Created by tomfuller on 19/06/2017.
 */
public class Item {

    public boolean isCheckedOut = false;
    String title;

    String getTitle() {
        return title;
    }

    public void checkOut() {
        isCheckedOut = true;
    }

    public String formatString() {
        return "";
    }

}
