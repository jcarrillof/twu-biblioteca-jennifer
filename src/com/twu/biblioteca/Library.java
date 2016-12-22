package com.twu.biblioteca;

import com.twu.dominio.Book;
import com.twu.dominio.Movie;
import com.twu.dominio.User;

public class Library{

    public Shelf<Book> bookShelf = new Shelf<>();
    public Shelf<Movie> movieShelf = new Shelf<>();

    public Library(){
        Book bookOne = new Book("Harry Potter", "J.K. Rowling", 1998);
        Book bookTwo = new Book("The Hobbit", "Tolkien", 2003);
        Book bookThree = new Book("The Lord of the Rings", "Tolkien", 2000);
        Movie movieOne = new Movie("Jaws", 1998, "Spielberg");
        Movie movieTwo = new Movie("Arrival", 2016, "Unknown", 10);
        Movie movieThree = new Movie("Titanic", 1996, "Cameron", 6);

        bookShelf.add(bookOne);
        bookShelf.add(bookTwo);
        bookShelf.add(bookThree);
        movieShelf.add(movieOne);
        movieShelf.add(movieTwo);
        movieShelf.add(movieThree);
    }

    public String listAvailableBooks(){
        return bookShelf.listAvailableItems();
    }

    public String listAvailableMovies() {
        return movieShelf.listAvailableItems();
    }

    public String checkoutBook(String nameBook, User userWhoCheckOutItem) {
        return bookShelf.checkoutItem(nameBook, userWhoCheckOutItem);
    }

    public String checkoutMovie(String nameMovie) {
        return movieShelf.checkoutItem(nameMovie, null);
    }

    public String returnBook(String nameBook) {
        return bookShelf.returnItem(nameBook);
    }

    public String returnMovie(String nameMovie) {
        return movieShelf.returnItem(nameMovie);
    }

    public String messageWhenQuitLibrary(){
        return MenuOptions.QUIT.nameOption();
    }

    public String messageToSelectValidOption(){
        return MenuOptions.NOT_VALID_OPTION.nameOption();
    }

    public String listCheckedOutItems() {
        String printFormat = "\n";
        for (Item book : bookShelf.itemsInShelf) {
            if (book.isItemCheckedOut()){
                printFormat += book.getUserWhoCheckedOut() + " -- " + book.getName() + "\n";
            }
        }
        return printFormat;
    }
}
