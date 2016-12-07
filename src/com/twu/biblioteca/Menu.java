package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private PrintStream printStream;

    Menu(PrintStream printStream){
        this.printStream = printStream;
    }

    public String actionFromSelectedOption(String inputFromScanner, List<Book> booksInLibrary) {
        switch (inputFromScanner){
            case "1":
                return getStringListAvailableBooks(booksInLibrary);
            case "2":
                String nameBookToCheckout = getNameBookFromInput();
                return checkoutBook(nameBookToCheckout, booksInLibrary);
            case "3":
                String nameBookToReturn = getNameBookFromInput();
                return returnBook(nameBookToReturn, booksInLibrary);
            case "0":
                return quitFromLibrary();
            default:
                return selectValidOption();
        }
    }

    private String getNameBookFromInput() {
        System.out.println("Name of book: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String getStringListAvailableBooks(List<Book> booksInLibrary){
        String printFormat = "";
        for (Book book : booksInLibrary) {
            if (!book.bookIsCheckedOut()){
                printFormat += (book.bookDetails() + "\n");
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
