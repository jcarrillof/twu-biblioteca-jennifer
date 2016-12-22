package com.twu.biblioteca;

import com.twu.resources.MenuOptions;
import com.twu.resources.Messages;
import com.twu.domain.User;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final int maximumNumberOption = 10;
    private final int minimumNumberOption = 0;
    private PrintStream printStream;
    private HashMap<Integer, ActionFromMenuGivenOption> actionsFromOptions;
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
            return actionsFromOptions.get(optionFromMenu).executeAction(nameItemWhenNeeded,
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
        actionsFromOptions.put(MenuOptions.LOG_IN.numberOption(), new ActionFromMenuGivenOption() {
            @Override
            public String executeAction(String nameItem, User userWhoLogIn) {
                return login.loginUser(userWhoLogIn);
            }
        });
        actionsFromOptions.put(MenuOptions.LIST_OF_BOOKS.numberOption(), new ActionFromMenuGivenOption() {
            @Override
            public String executeAction(String nameItem, User userWhoCheckOutItemWhenNeeded) {
                return library.listAvailableBooks();
            }
        });
        actionsFromOptions.put(MenuOptions.CHECKOUT_BOOK.numberOption(), new ActionFromMenuGivenOption() {
            @Override
            public String executeAction(String nameBook, User userWhoCheckOutItemWhenNeeded) {
                if(login.isActiveSession(userWhoCheckOutItemWhenNeeded)){
                    return library.checkoutBook(nameBook, userWhoCheckOutItemWhenNeeded);
                }
                return Messages.LOGIN_REQUIRED.toString();
            }
        });
        actionsFromOptions.put(MenuOptions.RETURN_BOOK.numberOption(), new ActionFromMenuGivenOption() {
            @Override
            public String executeAction(String nameBook, User userWhoCheckOutItemWhenNeeded) {
                if(login.isActiveSession(userWhoCheckOutItemWhenNeeded)){
                    return library.returnBook(nameBook);
                }
                return Messages.LOGIN_REQUIRED.toString();
            }
        });
        actionsFromOptions.put(MenuOptions.LIST_OF_MOVIES.numberOption(), new ActionFromMenuGivenOption() {
            @Override
            public String executeAction(String nameMovie, User userWhoCheckOutItemWhenNeeded) {
                return library.listAvailableMovies();
            }
        });
        actionsFromOptions.put(MenuOptions.CHECKOUT_MOVIE.numberOption(), new ActionFromMenuGivenOption() {
            @Override
            public String executeAction(String nameMovie, User userWhoCheckOutItemWhenNeeded) {
                return library.checkoutMovie(nameMovie);
            }
        });
        actionsFromOptions.put(MenuOptions.RETURN_MOVIE.numberOption(), new ActionFromMenuGivenOption() {
            @Override
            public String executeAction(String nameMovie, User userWhoCheckOutItemWhenNeeded) {
                return library.returnMovie(nameMovie);
            }
        });
        actionsFromOptions.put(MenuOptions.USER_INFORMATION.numberOption(), new ActionFromMenuGivenOption() {
            @Override
            public String executeAction(String nameMovie, User userLoggedIn) {
                if(login.isActiveSession(userLoggedIn)){
                    return login.getUserDetailsIsLoggedIn(userLoggedIn);
                }
                return Messages.LOGIN_REQUIRED.toString();
            }
        });
        actionsFromOptions.put(MenuOptions.USERS_WHO_CHECKOUT_BOOKS.numberOption(), new ActionFromMenuGivenOption() {
            @Override
            public String executeAction(String nameMovie, User userWhoCheckOutItemWhenNeeded) {
                return library.listCheckedOutItems();
            }
        });
        actionsFromOptions.put(MenuOptions.LOG_OUT.numberOption(), new ActionFromMenuGivenOption() {
            @Override
            public String executeAction(String nameItem, User userWhoLogIn) {
                return login.logoutUser(userWhoLogIn);
            }
        });
        actionsFromOptions.put(MenuOptions.QUIT.numberOption(), new ActionFromMenuGivenOption() {
            @Override
            public String executeAction(String nameItem, User userWhoCheckOutItemWhenNeeded) {
                return library.messageWhenQuitLibrary();
            }
        });
        actionsFromOptions.put(MenuOptions.NOT_VALID_OPTION.numberOption(), new ActionFromMenuGivenOption() {
            @Override
            public String executeAction(String nameItem, User userWhoCheckOutItemWhenNeeded) {
                return library.messageToSelectValidOption();
            }
        });
    }
}
