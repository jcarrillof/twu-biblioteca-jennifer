package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    private final int maximumNumberOption = 3;
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
                + MenuOptions.LISTOFBOOKS.toString()
                + MenuOptions.CHECKOUTBOOK.toString()
                + MenuOptions.RETURNBOOK.toString()
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
        return actionsFromOptions.get(optionFromMenu).serviceFromLibraryGivenOption(nameBookWhenNeeded);
    }

    public String getNameBookFromInput() {
        System.out.println("Name of book: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void listOfActionsForEachOption() {
        actionsFromOptions.put(MenuOptions.LISTOFBOOKS.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameBook) {
                return library.listAvailableBooks();
            }
        });
        actionsFromOptions.put(MenuOptions.CHECKOUTBOOK.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameBook) {
                return library.checkoutBook(nameBook);
            }
        });
        actionsFromOptions.put(MenuOptions.RETURNBOOK.numberOption(), new ServiceLibrary() {
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
        actionsFromOptions.put(MenuOptions.NOTVALIDOPTION.numberOption(), new ServiceLibrary() {
            @Override
            public String serviceFromLibraryGivenOption(String nameBook) {
                return library.messageToSelectValidOption();
            }
        });
    }
}
