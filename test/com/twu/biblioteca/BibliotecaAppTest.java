package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tomfuller on 29/05/2017.
 */
public class BibliotecaAppTest {
    @Test
    public void greetingTest() throws Exception {
        BibliotecaApp app = new BibliotecaApp();

        assertEquals(app.greet(), "Hello, welcome to Biblioteca!");

    }
}