package com.twu.biblioteca;

public enum Messages {

    SUCCESSFULCHECKOUT("Thank you! Enjoy the book"),
    UNSUCCESSFULCHECKOUT("That book is not available"),
    SUCCESSFULRETURN("Thank you for returning the book"),
    UNSUCCESSFULRETURN("That is not a valid book to return");

    private final String text;

    Messages(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
