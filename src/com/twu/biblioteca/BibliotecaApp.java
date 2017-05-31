package com.twu.biblioteca;
import java.util.*;

public class BibliotecaApp {

    private Book butteredParsnips = new Book("Buttered Parsnips", "Joe Lycett", 2016);
    private Book testDrivenDevelopment = new Book("Test Driven Development", "Kent Beck", 2003);
    private Book headFirstJava = new Book("Head First Java", "Kathy Sierra", 2005);
    Book[] bookArray = {butteredParsnips, testDrivenDevelopment, headFirstJava};
    String[] menuOptions = {"1. List books", "2. Quit", "3. Checkout Book"};


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
        else {
            System.out.println("Select a valid option!");
        }
        Menu();
    }

    public void checkoutBook() {
        String bookName = getBookNameFromUser();
        changeBookCheckoutStatus(bookName);
    }

    public void changeBookCheckoutStatus(String bookName) {
        boolean isBookInList = false;
        for (Book book: bookArray) {
            if (bookName.equals(book.getTitle())  ) {
                isBookInList = true;
                printSuccessfulCheckoutMessage();
                book.checkOut();
            }
        }
        if (isBookInList == false) {
            printUnsuccessfulCheckoutMessage();
        }
    }

    public String printSuccessfulCheckoutMessage() {
        String message = "Thank you! Enjoy the book";
        System.out.println(message);
        return message;

    }

    public String printUnsuccessfulCheckoutMessage() {
        String message = "That book is not available";
        System.out.println(message);
        return message;
    }

    public String getBookNameFromUser() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the book's title: ");
        return reader.nextLine();
    }

}
