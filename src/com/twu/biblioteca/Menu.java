package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    private final int maximumNumberOption = 5;
    private final int minimumNumberOption = 0;
    private PrintStream printStream;
    private HashMap<Integer, ServiceLibrary> actionsFromOptions;
    private Library library;

    public Menu(){
        printStream = System.out;
        actionsFromOptions = new HashMap<>();
        library = new Library();
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
                + MenuOptions.CHECKOUT_MOVIE.toString()
                + MenuOptions.RETURN_MOVIE.toString()
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

    public String doActionFromOption(int optionFromMenu, String nameBookWhenNeeded) {
        listOfActionsForEachOption();
        try {
            return actionsFromOptions.get(optionFromMenu).serviceFromLibraryGivenOption(nameBookWhenNeeded);
        }catch (NullPointerException exception){
            return Messages.NOT_FOUND_ACTION_IN_MAP.toString();
        }
    }

    public String getNameBookFromInput() {
        System.out.println(Messages.ASK_NAME_OF_BOOK);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void listOfActionsForEachOption() {
        actionsFromOptions.put(MenuOptions.LIST_OF_BOOKS.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameBook) {
                return library.listAvailableBooks();
            }
        });
        actionsFromOptions.put(MenuOptions.CHECKOUT_BOOK.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameBook) {
                return library.checkoutBook(nameBook);
            }
        });
        actionsFromOptions.put(MenuOptions.RETURN_BOOK.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameBook) {
                return library.returnBook(nameBook);
            }
        });
        actionsFromOptions.put(MenuOptions.QUIT.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameBook) {
                return library.messageWhenQuitLibrary();
            }
        });
        actionsFromOptions.put(MenuOptions.NOT_VALID_OPTION.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameBook) {
                return library.messageToSelectValidOption();
            }
        });
    }
}
