package com.twu.biblioteca;
import java.util.*;

public class BibliotecaApp {


    Library library = new Library();
    String[] menuOptions = {"1. List books", "2. Quit", "3. Checkout Book", "4. Return Book", "5. List Movies", "6. Checkout Movie"};
    UserAccount tom = new UserAccount("123-1234", "lemmein", "Daniel Danielson", "dandan@dan.com",  "07685356468");
    UserAccount rob = new UserAccount("987-9876", "password", "Rob", "robrob@rob.com", "0834737298");
    UserAccount[] users = {tom, rob};

    private UserAccount currentUser;

    public UserAccount getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserAccount currentUser) {
        this.currentUser = currentUser;
    }

    void userLogIn(String libraryNumber, String password) {
        for (UserAccount user: users) {
            if (user.verifyLibraryNumber(libraryNumber) && user.verifyPassword(password)) {
                setCurrentUser(user);
            }
        }
    }

    private String printCurrentUserInfo() {
        return currentUser.printUserInfo();
    }


    public static void main(String[] args) {
        BibliotecaApp bibApp = new BibliotecaApp();
        bibApp.greet();
        bibApp.Menu();
    }

    public String greet() {
        String welcomeMessage = "Hello, welcome to Biblioteca!";
        output(welcomeMessage);
        return welcomeMessage;
    }

    String printItemList(Item[] items) {
        String itemList = "";
        for (Item item: items) {
            if (!item.isCheckedOut) {
                itemList += item.formatString();
            }
        }
        output(itemList);
        return itemList;
    }

    public String showMenu() {
        String menu = "";
        for (String option : menuOptions) {
            menu += option + "\n";
        }
        if (!(currentUser == null)) {
            menu += "7. Show User Info";
        }
        output(menu);
        return menu;
    }

    public void Menu() {
        showMenu();
        int menuChoice = getUserMenuChoice();
        showMenuChoice(menuChoice);
    }

    public int getUserMenuChoice() {
        Scanner reader = new Scanner(System.in);
        output("Enter a number: ");
        return reader.nextInt();
    }

    private void showMenuChoice(int choice) {
        switch(choice) {
            case 1:
                printItemList(library.bookArray);
                break;
            case 2:
                return;
            case 3:
                if (!(getCurrentUser() == null)) {
                    checkoutItem(getItemNameFromUser(), library.bookArray);
                }
                break;
            case 4:
                returnBook(getItemNameFromUser());
                break;
            case 5:
                printItemList(library.movieArray);
                break;
            case 6:
                checkoutItem(getItemNameFromUser(), library.movieArray);
                break;
            case 7:
                if (!(currentUser == null)) {
                    printCurrentUserInfo();
                }
                break;
            default:
                output("Select a valid option!");
        }
        Menu();
    }

    public void returnBook (String bookName) {
        boolean isBookInList = false;
        for (Book book: library.bookArray) {
            if (bookName.equals(book.getTitle())  ) {
                isBookInList = true;
                book.returnBook();
            }
        }
        returnMessages(isBookInList);
    }

    void checkoutItem(String itemName, Item[] items) {
        boolean isBookInList = false;
        for (Item item : items) {
            if (itemName.equals(item.getTitle())) {
                isBookInList = true;
                item.checkOut();
            }
        }
        checkoutMessages(isBookInList);
    }

    public String checkoutMessages(boolean isSuccessful) {
        String message = "";
        if (isSuccessful) {
            message =  "Thank you! Enjoy the item";
        }
        else {
            message = "That item is not available";
        }
        output(message);
        return message;
    }

    public String returnMessages(boolean isSuccessful) {
        String message = "";
        if (isSuccessful) {
            message = "Thank you for returning the book.";
        }
        else {
            message = "That is not a valid book to return.";
        }
        output(message);
        return message;
    }


    private String getItemNameFromUser() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the item's title: ");
        return reader.nextLine();
    }

    private void output(String content) {
        System.out.println(content);
    }
}
