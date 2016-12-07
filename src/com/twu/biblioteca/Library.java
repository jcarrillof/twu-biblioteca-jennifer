package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<Book> booksInLibrary = new ArrayList<>();
    private Menu menu;
    private PrintStream printStream;

    public Library(PrintStream printStream) {
        this.printStream = printStream;
        menu = new Menu();

        Book bookOne = new Book("Book One", "Author One", "2016");
        bookOne.setBookIsCheckedOut(false);
        booksInLibrary.add(bookOne);

        Book bookTwo = new Book("Book Two", "Author Two", "2017");
        bookTwo.setBookIsCheckedOut(true);
        booksInLibrary.add(bookTwo);
    }

    public void printWelcomeMessage(){
        printStream.println("Welcome to Library!");
    }

    public void printMenu(){
        printStream.println(menu.getMenu());
    }

    public String readInputFromKeyboard(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String actionFromInputOption(String inputSelectedOption){
        switch (inputSelectedOption){
            case "1":
                return getStringListAvailableBooks();
            case "2":
                String nameBookToCheckout = getNameBookFromInput();
                return checkoutBook(nameBookToCheckout);
            case "3":
                String nameBookToReturn = getNameBookFromInput();
                return returnBook(nameBookToReturn);
            case "0":
                return quitFromLibrary();
            default:
                return selectValidOption();
        }
    }

    public String getStringListAvailableBooks(){
        String printFormat = "";
        for (Book book : booksInLibrary) {
            if (!book.bookIsCheckedOut()){
                printFormat += (book.bookDetails() + "\n");
            }
        }
        return printFormat;
    }

    public String checkoutBook(String nameBook) {
        for (Book book : booksInLibrary) {
            if(book.getName().equals(nameBook) && !book.bookIsCheckedOut()){
                return "Thank you! Enjoy the book";
            }
        }
        return "That book is not available";
    }

    public String returnBook(String nameBook) {
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

    private String getNameBookFromInput() {
        System.out.println("Name of book: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
