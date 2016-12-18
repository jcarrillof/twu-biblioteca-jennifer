package com.twu.biblioteca;

public enum MenuOptions {

    LIST_OF_BOOKS(1, "List of books"),
    CHECKOUT_BOOK(2, "Checkout a book"),
    RETURN_BOOK(3, "Return a book"),
    LIST_OF_MOVIES(4, "List of movies"),
    CHECKOUT_MOVIE(5, "Checkout a movie"),
    RETURN_MOVIE(6, "Return a movie"),
    USER_INFORMATION(7, "User information"),
    QUIT(0, "Quit"),
    NOT_VALID_OPTION(-1, "Select a valid option!");

    private final int numberOption;
    private final String nameOption;

    MenuOptions(int numberOption, String nameOption) {
        this.numberOption = numberOption;
        this.nameOption = nameOption;
    }

    public int numberOption() {
        return numberOption;
    }

    public String nameOption() {
        return nameOption;
    }

    @Override
    public String toString() {
        return numberOption + ". " + nameOption + "\n";
    }
}
