package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library{

    private final String messageUnsuccessfulCheckout = "That book is not available";
    private final String messageSuccessfulReturn = "Thank you for returning the book";
    private final String messageUnsuccessfulReturn = "That is not a valid book to return";
    private final String messageSuccessfulCheckout = "Thank you! Enjoy the book";
    public List<Book> booksInLibrary = new ArrayList<>();

    public Library(){
        Book bookOne = new Book("Harry Potter", "J.K. Rowling", 1998);
        booksInLibrary.add(bookOne);
        Book bookTwo = new Book("The Hobbit", "Tolkien", 2003);
        booksInLibrary.add(bookTwo);
        Book bookThree = new Book("The Lord of the Rings", "Tolkien", 2000);
        booksInLibrary.add(bookThree);
    }

    public String readInputFromKeyboard(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String listAvailableBooks(){
        String printFormat = "\n";
        for (Book book : booksInLibrary) {
            if (!book.bookIsCheckedOut()){
                printFormat += (book.bookDetails() + "\n");
            }
        }
        return printFormat;
    }

    public String messageFromCheckoutBook(String nameBook) {
        Book bookResult = changeBookStatusWhenCheckout(nameBook);
        if (bookResult != null && bookResult.bookIsCheckedOut()){
            return messageSuccessfulCheckout;
        }
        return messageUnsuccessfulCheckout;
    }

    private Book changeBookStatusWhenCheckout(String nameBook) {
        for (Book book : booksInLibrary) {
            if(book.getName().equals(nameBook) && !book.bookIsCheckedOut()){
                book.setBookIsCheckedOut(true);
                return book;
            }
        }
        return null;
    }

    public String messageFromReturnBook(String nameBook) {
        Book bookResult = changeBookStatusWhenReturn(nameBook);
        if (bookResult != null && !bookResult.bookIsCheckedOut()){
            return messageSuccessfulReturn;
        }
        return messageUnsuccessfulReturn;
    }

    private Book changeBookStatusWhenReturn(String nameBook) {
        for (Book book : booksInLibrary) {
            if (book.getName().equals(nameBook)) {
                book.setBookIsCheckedOut(false);
                return book;
            }
        }
        return null;
    }

    public String checkoutBook(String nameBook) {
        return messageFromCheckoutBook(nameBook);
    }

    public String returnBook(String nameBook) {
        return messageFromReturnBook(nameBook);
    }

    public String messageWhenQuitLibrary(){
        return MenuOptions.QUIT.nameOption();
    }

    public String messageToSelectValidOption(){
        return MenuOptions.NOTVALIDOPTION.nameOption();
    }
}
