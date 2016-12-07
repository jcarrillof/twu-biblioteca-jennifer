package com.twu.biblioteca;

public class Menu {

    public String getMenu() {
        return "\n/***** Menu *****/\n"
                + "1. List of books\n" + "2. Check-out books\n"
                + "3. Return book\n" + "0. Quit\n"
                + "\nSelect an option: ";
    }
}
