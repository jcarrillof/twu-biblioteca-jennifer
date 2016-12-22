package com.twu.resources;

public enum MenuOptions {

    LOG_IN(1, "Log In"),
    LIST_OF_BOOKS(2, "List of books"),
    CHECKOUT_BOOK(3, "Checkout a book"),
    RETURN_BOOK(4, "Return a book"),
    LIST_OF_MOVIES(5, "List of movies"),
    CHECKOUT_MOVIE(6, "Checkout a movie"),
    RETURN_MOVIE(7, "Return a movie"),
    USER_INFORMATION(8, "User information"),
    USERS_WHO_CHECKOUT_BOOKS(9, "Users who checked out books"),
    LOG_OUT(10, "Log Out"),
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
