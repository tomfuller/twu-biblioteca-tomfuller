package com.twu.biblioteca;
import java.util.*;

public class BibliotecaApp {


    Book butteredParsnips = new Book("Buttered Parsnips", "Joe Lycett", 2016);
    Book testDrivenDevelopment = new Book("Test Driven Development", "Kent Beck", 2003);
    Book headFirstJava = new Book("Head First Java", "Kathy Sierra", 2005);
    Book[] bookArray = {butteredParsnips, testDrivenDevelopment, headFirstJava};
    Movie aKnightsTale = new Movie("A Knights Tale", 2001, "Brian Helgeland", "7");
    Movie drStrange = new Movie("Dr Strange", 2016, "Scott Derrickson", "8");
    Movie[] movieArray = {aKnightsTale, drStrange};
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

    String printCurrentUserInfo() {
        return currentUser.getName() + ", " + currentUser.getEmail() + ", " + currentUser.getPhoneNumber();
    }


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
            if (!movie.isCheckedOut) {
                movieList += movie.getName() + ", " + movie.getYear() + ", " + movie.getDirector() + ", " + movie.getRating() + "\n";
            }
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
        String menu = "";
        for (String option : menuOptions) {
            menu += option + "\n";
        }
        if (!(currentUser == null)) {
            menu += "7. Show User Info";
        }
        System.out.println(menu);
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
            if (!(getCurrentUser() == null)) {
                actOnBook("checkout");
            }
        }
        else if(choice == 4) {
            actOnBook("return");
        }
        else if(choice == 5) {
            printItemList("movie");
        }
        else if(choice == 6) {
            checkoutMovie(getBookNameFromUser());
        }
        else if((choice == 7) && !(currentUser == null)) {
            printCurrentUserInfo();
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

    void checkoutMovie(String movieTitle) {
        for (Movie movie: movieArray) {
            if (movieTitle.equals(movie.getName())) {
                movie.checkout();
            }
        }
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
        System.out.println("Enter the item's title: ");
        return reader.nextLine();
    }
}
