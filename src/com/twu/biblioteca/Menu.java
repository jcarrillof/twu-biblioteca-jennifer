package com.twu.biblioteca;

import java.io.PrintStream;

public class Menu {

    private PrintStream printStream;

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
                + "1. List of books\n"
                + "2. Check-out books\n"
                + "3. Return book\n"
                + "0. Quit\n"
                + "\nSelect an option: ";
    }
}
