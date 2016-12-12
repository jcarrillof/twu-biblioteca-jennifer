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
            if (!book.bookIsCheckedOut()){
                printFormat += (book.bookDetails() + "\n");
            }
        }
        return printFormat;
    }

    public String messageFromCheckoutBook(String nameBook) {
        Book bookResult = changeBookStatusWhenCheckout(nameBook);
        if (bookResult != null && bookResult.bookIsCheckedOut()){
            return "Thank you! Enjoy the book";
        }
        return "That book is not available";
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
            return "Thank you for returning the book";
        }
        return "That is not a valid book to return";
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

    public void printStatus(){
        for (Book book : booksInLibrary) {
            System.out.println(book.getAuthor() + "  " + book.bookIsCheckedOut());
        }
    }
}
