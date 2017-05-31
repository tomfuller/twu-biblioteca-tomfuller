package com.twu.biblioteca;
import java.util.*;

public class BibliotecaApp {

    private Book butteredParsnips = new Book("Buttered Parsnips", "Joe Lycett", 2016);
    private Book testDrivenDevelopment = new Book("Test Driven Development", "Kent Beck", 2003);
    private Book headFirstJava = new Book("Head First Java", "Kathy Sierra", 2005);
    Book[] bookArray = {butteredParsnips, testDrivenDevelopment, headFirstJava};
    String[] menuOptions = {"1. List books", "2. Quit", "3. Checkout Book", "4. Return Book"};


    public static void main(String[] args) {
        BibliotecaApp bibApp = new BibliotecaApp();
        bibApp.greet();
        bibApp.Menu();
    }

    public String greet() {
        String welcomeMessage = "Hello, welcome to Biblioteca!";
        System.out.println(welcomeMessage);
        return welcomeMessage;
    }

    public String printBookList() {
        String bookList = formatBookString();
        System.out.println(bookList);
        return bookList;
    }

    private String formatBookString() {
        String bookList = "";
        for (Book book: bookArray){
            if (!book.isCheckedOut) {
                bookList += book.getTitle() + ", " + book.getAuthor() + ", " + book.getYearPublished() + "\n";
            }
        }
        return bookList;
    }

    public String showMenu() {
        String menu = String.join("\n", menuOptions);
        return menu;
    }

    public void Menu() {
        showMenu();
        int menuChoice = getUserMenuChoice();
        showMenuChoice(menuChoice);
    }

    public int getUserMenuChoice() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a number: ");
        return reader.nextInt();
    }

    public void showMenuChoice(int choice) {
        if(choice == 1) {
            printBookList();
        }
        else if(choice == 2) {
            return;
        }
        else if(choice == 3) {
            checkoutBook();
        }

        else if(choice == 4) {
            returnBook();
        }
        else {
            System.out.println("Select a valid option!");
        }
        Menu();
    }

    public void checkoutBook() {
        String bookName = getBookNameFromUser();
        changeBookCheckoutStatus(bookName);
    }

    public void returnBook() {
        String bookName = getBookNameFromUser();
        changeBookReturnStatus(bookName);
    }

    public void changeBookCheckoutStatus(String bookName) {
        boolean isBookInList = false;
        for (Book book: bookArray) {
            if (bookName.equals(book.getTitle())  ) {
                isBookInList = true;
                book.checkOut();
            }
        }
        String messageAction = "checkout";
        printMessage(isBookInList, messageAction);
    }

    public String printMessage(boolean isSuccessful, String messageAction) {
        String message = "";
        if (messageAction.equals("checkout")) {
            if (isSuccessful) {
                message = "Thank you! Enjoy the book";
            }
            else {
                message = "That book is not available";
            }
        }
        if (messageAction.equals("return")) {
            if (isSuccessful) {
                message = "Thank you for returning the book.";
            }
            else {
                message = "That is not a valid book to return.";
            }
        }
        System.out.println(message);
        return message;
    }


    public String getBookNameFromUser() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the book's title: ");
        return reader.nextLine();
    }

    public void changeBookReturnStatus(String bookName) {
        boolean isBookInList = false;
        for (Book book: bookArray) {
            if (bookName.equals(book.getTitle())  ) {
                isBookInList = true;
                book.returnBook();
            }
        }
        String messageAction = "return";
        printMessage(isBookInList, messageAction);
    }
}
