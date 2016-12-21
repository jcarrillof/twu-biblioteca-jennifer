package com.twu.biblioteca;

import com.twu.dominio.User;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final int maximumNumberOption = 10;
    private final int minimumNumberOption = 0;
    private PrintStream printStream;
    private HashMap<Integer, ServiceLibrary> actionsFromOptions;
    private Library library;
    private Login login;

    public Menu(){
        printStream = System.out;
        actionsFromOptions = new HashMap<>();
        library = new Library();
        login = new Login();
    }

    public Menu(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printWelcomeMessage() {
        printStream.println("Welcome to Library!");
    }

    public void printMenu(){
        String menuString = getMenuString();
        printStream.println(menuString);
    }

    private String getMenuString() {
        return "\n/***** Menu *****/\n"
                + MenuOptions.LOG_IN.toString()
                + MenuOptions.LIST_OF_BOOKS.toString()
                + MenuOptions.CHECKOUT_BOOK.toString()
                + MenuOptions.RETURN_BOOK.toString()
                + MenuOptions.LIST_OF_MOVIES.toString()
                + MenuOptions.CHECKOUT_MOVIE.toString()
                + MenuOptions.RETURN_MOVIE.toString()
                + MenuOptions.USER_INFORMATION.toString()
                + MenuOptions.USERS_WHO_CHECKOUT_BOOKS.toString()
                + MenuOptions.LOG_OUT.toString()
                + MenuOptions.QUIT.toString()
                + "\nSelect an option: ";
    }

    public int numberOptionFromInputString(String inputString) {
        int numberOption;
        try {
            numberOption = Integer.parseInt(inputString);
            if(numberOption < minimumNumberOption || numberOption > maximumNumberOption){
                numberOption = -1;
            }
        }catch (NumberFormatException exception){
            numberOption = -1;
        }
        return numberOption;
    }

    public String readInputFromKeyboard(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public List<String> getInputCredentials(){
        return login.getInputCredentials();
    }

    public User validateCredentials(List<String> credentials){
        return login.validCredentials(credentials.get(0), credentials.get(1));
    }

    public String doActionFromOption(int optionFromMenu, String nameItemWhenNeeded, User userWhoCheckOutItemWhenNeeded) {
        listOfActionsForEachOption();
        try {
            return actionsFromOptions.get(optionFromMenu).serviceFromLibraryGivenOption(nameItemWhenNeeded,
                    userWhoCheckOutItemWhenNeeded);
        }catch (NullPointerException exception){
            return Messages.NOT_FOUND_ACTION_IN_MAP.toString();
        }
    }

    public String getNameItemFromInput() {
        System.out.println(Messages.ASK_NAME_OF_ITEM);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void listOfActionsForEachOption() {
        actionsFromOptions.put(MenuOptions.LOG_IN.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameItem, User userWhoLogIn) {
                try {
                    userWhoLogIn.setUserLogin(true);
                    if(userWhoLogIn.isUserLogin()){
                        return Messages.CREDENTIALS_VALID.toString();
                    }
                    return Messages.SESSION_ACTIVE.toString();
                }catch (Exception exception){
                    return Messages.CREDENTIALS_NOT_VALID.toString();
                }
            }
        });
        actionsFromOptions.put(MenuOptions.LIST_OF_BOOKS.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameItem, User userWhoCheckOutItemWhenNeeded) {
                return library.listAvailableBooks();
            }
        });
        actionsFromOptions.put(MenuOptions.CHECKOUT_BOOK.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameBook, User userWhoCheckOutItemWhenNeeded) {
                try {
                    if(userWhoCheckOutItemWhenNeeded.isUserLogin()){
                        return library.checkoutBook(nameBook, userWhoCheckOutItemWhenNeeded);
                    }
                    return Messages.LOGIN_REQUIRED.toString();
                }catch (Exception exception){
                    return Messages.LOGIN_REQUIRED.toString();
                }
            }
        });
        actionsFromOptions.put(MenuOptions.RETURN_BOOK.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameBook, User userWhoCheckOutItemWhenNeeded) {
                try {
                    if(userWhoCheckOutItemWhenNeeded.isUserLogin()){
                        return library.returnBook(nameBook);
                    }
                    return Messages.LOGIN_REQUIRED.toString();
                }catch (Exception exception){
                    return Messages.LOGIN_REQUIRED.toString();
                }
            }
        });
        actionsFromOptions.put(MenuOptions.LIST_OF_MOVIES.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameMovie, User userWhoCheckOutItemWhenNeeded) {
                return library.listAvailableMovies();
            }
        });
        actionsFromOptions.put(MenuOptions.CHECKOUT_MOVIE.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameMovie, User userWhoCheckOutItemWhenNeeded) {
                return library.checkoutMovie(nameMovie);
            }
        });
        actionsFromOptions.put(MenuOptions.RETURN_MOVIE.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameMovie, User userWhoCheckOutItemWhenNeeded) {
                return library.returnMovie(nameMovie);
            }
        });
        actionsFromOptions.put(MenuOptions.USER_INFORMATION.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameMovie, User userLoggedIn) {
                if(userLoggedIn.isUserLogin()){
                    return login.getUserDetailsIsLoggedIn(userLoggedIn);
                }
                return Messages.LOGIN_REQUIRED.toString();
            }
        });
        actionsFromOptions.put(MenuOptions.USERS_WHO_CHECKOUT_BOOKS.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameMovie, User userWhoCheckOutItemWhenNeeded) {
                return library.listCheckedOutItems();
            }
        });
        actionsFromOptions.put(MenuOptions.LOG_OUT.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameItem, User userWhoLogIn) {
                try {
                    userWhoLogIn.setUserLogin(false);
                    if(!userWhoLogIn.isUserLogin()){
                        return "You logged out";
                    }
                    return "Error when try to log out";
                }catch (Exception exception){
                    return Messages.SESSION_INACTIVE.toString();
                }
            }
        });
        actionsFromOptions.put(MenuOptions.QUIT.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameItem, User userWhoCheckOutItemWhenNeeded) {
                return library.messageWhenQuitLibrary();
            }
        });
        actionsFromOptions.put(MenuOptions.NOT_VALID_OPTION.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameItem, User userWhoCheckOutItemWhenNeeded) {
                return library.messageToSelectValidOption();
            }
        });
    }
}
