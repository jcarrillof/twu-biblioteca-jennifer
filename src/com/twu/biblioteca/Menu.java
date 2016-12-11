package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    private PrintStream printStream;
    private HashMap<Integer, String> actionsFromOptions;

    public Menu(){
        printStream = System.out;
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
                + MenuOptions.LISTOFBOOKS
                + MenuOptions.CHECKOUTBOOK
                + MenuOptions.RETURNBOOK
                + MenuOptions.QUIT
                + "\nSelect an option: ";
    }

    public int numberOptionFromInputString(String inputString) {
        int numberOption;
        try {
            numberOption = Integer.parseInt(inputString);
            if(numberOption < 0 || numberOption > 3){
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
        listOfActionsForEachOption(nameBookWhenNeeded);
        return actionsFromOptions.get(optionFromMenu);
    }

    public String getNameBookFromInput() {
        System.out.println("Name of book: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void listOfActionsForEachOption(String nameBook) {
        Library library = new Library();
        actionsFromOptions = new HashMap<>();
        actionsFromOptions.put(MenuOptions.LISTOFBOOKS.numberOption(), library.listAvailableBooks());
        actionsFromOptions.put(MenuOptions.CHECKOUTBOOK.numberOption(), library.checkoutBook(nameBook));
        actionsFromOptions.put(MenuOptions.RETURNBOOK.numberOption(), library.returnBook(nameBook));
        actionsFromOptions.put(MenuOptions.QUIT.numberOption(), messageWhenQuitLibrary());
        actionsFromOptions.put(MenuOptions.NOTVALIDOPTION.numberOption(), messageToSelectValidOption());
    }

    private String messageWhenQuitLibrary(){
        return MenuOptions.QUIT.nameOption();
    }

    private String messageToSelectValidOption(){
        return MenuOptions.NOTVALIDOPTION.nameOption();
    }
}
