package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    private PrintStream printStream;
    private HashMap<Integer, String> actionsFromOptions;

    public Menu(){
        printStream = System.out;
        listOfActionsForEachOption();
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
                + "1. List of books\n"
                + "2. Check-out books\n"
                + "3. Return book\n"
                + "0. Quit\n"
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

    public String doActionFromOption(int optionFromMenu) {
        return actionsFromOptions.get(optionFromMenu);
    }

    private void listOfActionsForEachOption() {
        Library library = new Library();
        actionsFromOptions = new HashMap<>();
        actionsFromOptions.put(1, library.listAvailableBooks());
        actionsFromOptions.put(2, library.checkoutBook());
        actionsFromOptions.put(3, library.returnBook());
        actionsFromOptions.put(0, messageWhenQuitLibrary());
        actionsFromOptions.put(-1, messageToSelectValidOption());
    }

    private String messageWhenQuitLibrary(){
        return "Quit";
    }

    private String messageToSelectValidOption(){
        return "Select a valid option!";
    }
}
