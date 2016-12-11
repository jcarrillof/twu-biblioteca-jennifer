package com.twu.biblioteca;

public enum MenuOptions {

    LISTOFBOOKS(1, "List of books"),
    CHECKOUTBOOK(2, "Checkout a book"),
    RETURNBOOK(3, "Return a book"),
    QUIT(0, "Quit"),
    NOTVALIDOPTION(-1, "Select a valid option!");

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
