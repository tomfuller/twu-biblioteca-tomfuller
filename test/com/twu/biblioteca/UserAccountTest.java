package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tomfuller on 16/06/2017.
 */
public class UserAccountTest {

    UserAccount user = new UserAccount("123-1234", "lemmein", "Daniel Danielson", "dandan@dan.com", "07685356468");

    @Test
    public void verifyLibraryNumberInputMatchesLibraryNumberOfAccount() throws Exception {
        assertEquals(true, user.verifyLibraryNumber("123-1234"));
    }

    @Test
    public void verifyPasswordInputMatchedPasswordOfAccount() throws Exception {
        assertEquals(true, user.verifyPassword("lemmein"));
    }
}