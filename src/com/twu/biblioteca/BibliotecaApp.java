package com.twu.biblioteca;
import java.util.*;

public class BibliotecaApp {


    private Book butteredParsnips = new Book("Buttered Parsnips", "Joe Lycett", 2016);
    private Book testDrivenDevelopment = new Book("Test Driven Development", "Kent Beck", 2003);
    private Book headFirstJava = new Book("Head First Java", "Kathy Sierra", 2005);
    Book[] bookArray = {butteredParsnips, testDrivenDevelopment, headFirstJava};
    private Movie aKnightsTale = new Movie("A Knights Tale", 2001, "Brian Helgeland", "7");
    private Movie drStrange = new Movie("Dr Strange", 2016, "Scott Derrickson", "8");
    Movie[] movieArray = {aKnightsTale, drStrange};
    String[] menuOptions = {"1. List books", "2. Quit", "3. Checkout Book", "4. Return Book", "5. List Movies"};


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

    String printItemList(String item) {
        String itemList = "";
        if(item.equals("movie")) { itemList = formatMovieString(); }
        else if(item.equals("book")) {itemList = formatBookString(); }
        System.out.println(itemList);
        return itemList;
    }

    String formatMovieString() {
        String movieList = "";
        for (Movie movie: movieArray){
                movieList += movie.getName() + ", " + movie.getYear() + ", " + movie.getDirector() + ", " + movie.getRating() + "\n";
        }
        return movieList;
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
            printItemList("book");
        }
        else if(choice == 2) {
            return;
        }
        else if(choice == 3) {
            actOnBook("checkout");
        }
        else if(choice == 4) {
            actOnBook("return");
        }
        else if(choice == 5) {
            printItemList("movie");
        }
        else {
            System.out.println("Select a valid option!");
        }
        Menu();
    }

    public void actOnBook(String action) {
        String bookName = getBookNameFromUser();
        changeBookStatus(bookName, action);
    }



    public void changeBookStatus(String bookName, String action) {
        boolean isBookInList = false;
        for (Book book: bookArray) {
            if (bookName.equals(book.getTitle())  ) {
                isBookInList = true;
                if (action.equals("checkout")) {
                    book.checkOut();
                }
                else if (action.equals("return")) {
                    book.returnBook();
                }
            }
        }
        printMessage(isBookInList, action);
    }


    public String printMessage(boolean isSuccessful, String messageAction) {
        String message = findMessage(isSuccessful, messageAction);
        System.out.println(message);
        return message;
    }

    private String findMessage(boolean isSuccessful, String messageAction) {
        if (messageAction.equals("checkout")) {
            return checkoutMessages(isSuccessful);
        }
        else {
            return returnMessages(isSuccessful);
        }

    }

    private String checkoutMessages(boolean isSuccessful) {
        if (isSuccessful) {
            return "Thank you! Enjoy the book";
        }
        else {
            return "That book is not available";
        }
    }

    private String returnMessages(boolean isSuccessful) {
        if (isSuccessful) {
            return "Thank you for returning the book.";
        }
        else {
            return "That is not a valid book to return.";
        }
    }


    private String getBookNameFromUser() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the book's title: ");
        return reader.nextLine();
    }
}
