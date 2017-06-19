package com.twu.biblioteca;

/**
 * Created by tomfuller on 16/06/2017.
 */
public class UserAccount {

    public UserAccount(String libraryID, String pword, String usersName, String emailAddress, String phone) {
        libraryNumber = libraryID;
        password = pword;
        name = usersName;
        email = emailAddress;
        phoneNumber = phone;

    }

    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;


    boolean verifyLibraryNumber(String numberToCheck) {
        return numberToCheck == libraryNumber;
    }

    boolean verifyPassword(String passwordToCheck) {
        return passwordToCheck == password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String printUserInfo() {
        return getName() + ", " + getEmail() + ", " + getPhoneNumber();
    }

}
