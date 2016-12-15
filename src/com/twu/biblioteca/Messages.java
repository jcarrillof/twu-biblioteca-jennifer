package com.twu.biblioteca;

public enum Messages {

    SUCCESSFUL_CHECKOUT_BOOK("Thank you! Enjoy the book"),
    UNSUCCESSFUL_CHECKOUT_BOOK("That book is not available"),
    SUCCESSFUL_RETURN_BOOK("Thank you for returning the book"),
    UNSUCCESSFUL_RETURN_BOOK("That is not a valid book to return"),
    SUCCESSFUL_CHECKOUT_MOVIE("Thank you! Enjoy the movie"),
    UNSUCCESSFUL_CHECKOUT_MOVIE("That movie is not available");

    private final String text;

    Messages(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
