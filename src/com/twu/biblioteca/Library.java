package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    public List<Book> booksInLibrary;

    public Library(){

        booksInLibrary = new ArrayList<>();
        Book bookOne = new Book("Harry Potter", "J.K. Rowling", 1998);
        booksInLibrary.add(bookOne);
        Book bookTwo = new Book("The Hobbit", "Tolkien", 2003);
        booksInLibrary.add(bookTwo);
    }

    public String readInputFromKeyboard(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String listAvailableBooks(){
        String printFormat = "";
        for (Book book : booksInLibrary) {
            if (!book.bookIsCheckedOut()){
                printFormat += (book.bookDetails() + "\n");
            }
        }
        return printFormat;
    }

    public String messageFromCheckoutBook(String nameBook) {
        for (Book book : booksInLibrary) {
            if(book.getName().equals(nameBook) && !book.bookIsCheckedOut()){
                book.setBookIsCheckedOut(true);
                return "Thank you! Enjoy the book";
            }
        }
        return "That book is not available";
    }

    public String messageFromReturnBook(String nameBook) {
        for (Book book : booksInLibrary) {
            if (book.getName().equals(nameBook)){
                book.setBookIsCheckedOut(false);
                return "Thank you for returning the book";
            }
        }
        return "That is not a valid book to return";
    }

    public String checkoutBook(String nameBook) {
        return messageFromCheckoutBook(nameBook);
    }

    public String returnBook(String nameBook) {
        return messageFromReturnBook(nameBook);
    }
}
