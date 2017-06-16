package com.twu.biblioteca;

/**
 * Created by tomfuller on 16/06/2017.
 */
public class UserAccount {

    public UserAccount(String libraryID, String pword) {
        libraryNumber = libraryID;
        password = pword;
    }

    private String libraryNumber;
    private String password;

    boolean verifyLibraryNumber(String numberToCheck) {
        return numberToCheck == libraryNumber;
    }

    boolean verifyPassword(String passwordToCheck) {
        return passwordToCheck == password;
    }

}
