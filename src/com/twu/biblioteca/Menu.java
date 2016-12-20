package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final int maximumNumberOption = 8;
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
                + MenuOptions.LIST_OF_BOOKS.toString()
                + MenuOptions.CHECKOUT_BOOK.toString()
                + MenuOptions.RETURN_BOOK.toString()
                + MenuOptions.LIST_OF_MOVIES.toString()
                + MenuOptions.CHECKOUT_MOVIE.toString()
                + MenuOptions.RETURN_MOVIE.toString()
                + MenuOptions.USER_INFORMATION.toString()
                + MenuOptions.RESPONSIBLE_USERS_ITEMS.toString()
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

    public int validateCredentials(List<String> credentials){
        return login.validCredentials(credentials.get(0), credentials.get(1));
    }

    public String doActionFromOption(int optionFromMenu, String nameItemWhenNeeded, int userResponsibleWhenNeeded) {
        listOfActionsForEachOption();
        try {
            return actionsFromOptions.get(optionFromMenu).serviceFromLibraryGivenOption(nameItemWhenNeeded,
                    userResponsibleWhenNeeded);
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
        actionsFromOptions.put(MenuOptions.LIST_OF_BOOKS.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameItem, int userResponsible) {
                return library.listAvailableBooks();
            }
        });
        actionsFromOptions.put(MenuOptions.CHECKOUT_BOOK.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameBook, int userResponsible) {
                try {
                    String userResponsibleName = login.listUsers.get(userResponsible).getName();
                    return library.checkoutBook(nameBook, userResponsibleName);
                }catch (Exception exception){
                    return Messages.CREDENTIALS_NOT_VALID.toString();
                }
            }
        });
        actionsFromOptions.put(MenuOptions.RETURN_BOOK.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameBook, int userResponsible) {
                try {
                    login.listUsers.get(userResponsible);
                    return library.returnBook(nameBook);
                }catch (Exception exception){
                    return Messages.CREDENTIALS_NOT_VALID.toString();
                }
            }
        });
        actionsFromOptions.put(MenuOptions.LIST_OF_MOVIES.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameMovie, int userResponsible) {
                return library.listAvailableMovies();
            }
        });
        actionsFromOptions.put(MenuOptions.CHECKOUT_MOVIE.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameMovie, int userResponsible) {
                return library.checkoutMovie(nameMovie);
            }
        });
        actionsFromOptions.put(MenuOptions.RETURN_MOVIE.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameMovie, int userResponsible) {
                return library.returnMovie(nameMovie);
            }
        });
        actionsFromOptions.put(MenuOptions.USER_INFORMATION.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameMovie, int userResponsible) {
                return login.getUserDetailsIsLoggedIn(userResponsible);
            }
        });
        actionsFromOptions.put(MenuOptions.RESPONSIBLE_USERS_ITEMS.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameMovie, int userResponsible) {
                return library.listCheckedOutItems();
            }
        });
        actionsFromOptions.put(MenuOptions.QUIT.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameItem, int userResponsible) {
                return library.messageWhenQuitLibrary();
            }
        });
        actionsFromOptions.put(MenuOptions.NOT_VALID_OPTION.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameItem, int userResponsible) {
                return library.messageToSelectValidOption();
            }
        });
    }
}
