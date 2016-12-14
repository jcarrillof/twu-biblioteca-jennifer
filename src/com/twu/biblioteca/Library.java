package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library{

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
            if (!book.itemIsCheckedOut()){
                printFormat += book.itemDetails();
            }
        }
        return printFormat;
    }

    private String messageFromCheckoutBook(String nameBook) {
        Book bookResult = changeBookStatusWhenCheckout(nameBook);
        if (bookResult != null && bookResult.itemIsCheckedOut()){
            return Messages.SUCCESSFULCHECKOUT.toString();
        }
        return Messages.UNSUCCESSFULCHECKOUT.toString();
    }

    private Book changeBookStatusWhenCheckout(String nameBook) {
        for (Book book : booksInLibrary) {
            if(book.getName().equals(nameBook) && !book.itemIsCheckedOut()){
                book.setItemIsCheckedOut(true);
                return book;
            }
        }
        return null;
    }

    private String messageFromReturnBook(String nameBook) {
        Book bookResult = changeBookStatusWhenReturn(nameBook);
        if (bookResult != null && !bookResult.itemIsCheckedOut()){
            return Messages.SUCCESSFULRETURN.toString();
        }
        return Messages.UNSUCCESSFULRETURN.toString();
    }

    private Book changeBookStatusWhenReturn(String nameBook) {
        for (Book book : booksInLibrary) {
            if (book.getName().equals(nameBook)) {
                book.setItemIsCheckedOut(false);
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
