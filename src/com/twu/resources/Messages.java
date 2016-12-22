package com.twu.resources;

public enum Messages {

    SUCCESSFUL_CHECKOUT_BOOK("Thank you! Enjoy the book"),
    UNSUCCESSFUL_CHECKOUT_ITEM("That item is not available"),
    SUCCESSFUL_CHECKOUT_MOVIE("Thank you! Enjoy the movie"),
    SUCCESSFUL_RETURN_ITEM("Thank you for returning the item"),
    UNSUCCESSFUL_RETURN_ITEM("That is not a valid item to return"),
    NOT_FOUND_ACTION_IN_MAP("Action not found!"),
    ASK_NAME_OF_ITEM("Name of item: "),
    LOGIN_REQUIRED("You must be logged in"),
    CREDENTIALS_NOT_VALID("Credentials are not valid"),
    CREDENTIALS_VALID("You are now logged in"),
    SESSION_ACTIVE("You are already logged in or change to another user account"),
    SESSION_INACTIVE("There is no active session"),
    USER_LOGOUT("You logged out");

    private final String text;

    Messages(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
