package com.twu.biblioteca;

import java.util.List;

public class Menu {

    public String actionFromSelectedOption(String inputFromScanner, List<Book> booksInLibrary) {
        switch (inputFromScanner){
            case "1":
                printListAvailableBooks(booksInLibrary);
                return "";
            case "2":
                checkoutBook("Book One", booksInLibrary);
                return "";
            case "3":
                returnBook("Book One", booksInLibrary);
                return "";
            case "0":
                return quitFromLibrary();
            default:
                return selectValidOption();
        }
    }

    private void printListAvailableBooks(List<Book> booksAvailableInLibrary){
        getStringListAvailableBooks(booksAvailableInLibrary);
    }

    private String getStringListAvailableBooks(List<Book> booksInLibrary){
        String printFormat = "";
        for (Book book : booksInLibrary) {
            if (book.bookIsCheckedOut()){
                printFormat += (book.toString() + "\n");
            }
        }
        return printFormat;
    }

    public String checkoutBook(String nameBook, List<Book> booksInLibrary) {
        for (Book book : booksInLibrary) {
            if(book.getName().equals(nameBook) && !book.bookIsCheckedOut()){
                return "Thank you! Enjoy the book";
            }
        }
        return "That book is not available";
    }

    public String returnBook(String nameBook, List<Book> booksInLibrary) {
        for (Book book : booksInLibrary) {
            if (book.getName().equals(nameBook)){
                return "Thank you for returning the book";
            }
        }
        return "That is not a valid book to return";
    }

    private String quitFromLibrary(){
        return "Quit";
    }

    private String selectValidOption(){
        return "Select a valid option!";
    }

    public String getMenu() {
        return "\n/***** Menu *****/\n"
                + "1. List of books\n" + "2. Check-out books\n"
                + "3. Return book\n" + "0. Quit\n"
                + "\nSelect an option: ";
    }
}
