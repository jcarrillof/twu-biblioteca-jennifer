package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library{

    public List<Movie> moviesInLibrary = new ArrayList<>();
    public List<Book> booksInLibrary = new ArrayList<>();

    public Library(){
        Book bookOne = new Book("Harry Potter", "J.K. Rowling", 1998);
        booksInLibrary.add(bookOne);
        Book bookTwo = new Book("The Hobbit", "Tolkien", 2003);
        booksInLibrary.add(bookTwo);
        Book bookThree = new Book("The Lord of the Rings", "Tolkien", 2000);
        booksInLibrary.add(bookThree);
        Movie movieOne = new Movie("Jaws", 1998, "Spielberg");
        moviesInLibrary.add(movieOne);
        Movie movieTwo = new Movie("Arrival", 2016, "Unknown", 10);
        moviesInLibrary.add(movieTwo);
        Movie movieThree = new Movie("Titanic", 1996, "Cameron", 6);
        moviesInLibrary.add(movieThree);
    }

    public String readInputFromKeyboard(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String listAvailableBooks(){
        String printFormat = "\n";
        for (Book book : booksInLibrary) {
            if (!book.isBookCheckout()){
                printFormat += book.bookDetails();
            }
        }
        return printFormat;
    }

    public String listAvailableMovies() {
        String printFormat = "\n";
        for (Movie movie : moviesInLibrary) {
            if (!movie.isMovieCheckout()){
                printFormat += movie.movieDetails();
            }
        }
        return printFormat;
    }

    private String messageFromCheckoutBook(String nameBook) {
        Book bookResult = changeBookStatusWhenCheckout(nameBook);
        if (bookResult != null && bookResult.isBookCheckout()){
            return Messages.SUCCESSFUL_CHECKOUT_BOOK.toString();
        }
        return Messages.UNSUCCESSFUL_CHECKOUT_BOOK.toString();
    }

    private String messageFromCheckoutMovie(String nameMovie) {
        Movie movieResult = changeMovieStatusWhenCheckout(nameMovie);
        if (movieResult != null && movieResult.isMovieCheckout()){
            return Messages.SUCCESSFUL_CHECKOUT_MOVIE.toString();
        }
        return Messages.UNSUCCESSFUL_CHECKOUT_MOVIE.toString();
    }

    private Book changeBookStatusWhenCheckout(String nameBook) {
        for (Book book : booksInLibrary) {
            if(book.getName().equals(nameBook) && !book.isBookCheckout()){
                book.setBookIsCheckedOut(true);
                return book;
            }
        }
        return null;
    }

    private Movie changeMovieStatusWhenCheckout(String nameMovie) {
        for (Movie movie : moviesInLibrary) {
            if(movie.getName().equals(nameMovie) && !movie.isMovieCheckout()){
                movie.setMovieIsCheckedOut(true);
                return movie;
            }
        }
        return null;
    }

    private String messageFromReturnBook(String nameBook) {
        Book bookResult = changeBookStatusWhenReturn(nameBook);
        if (bookResult != null && !bookResult.isBookCheckout()){
            return Messages.SUCCESSFUL_RETURN_BOOK.toString();
        }
        return Messages.UNSUCCESSFUL_RETURN_BOOK.toString();
    }

    private String messageFromReturnMovie(String nameMovie) {
        Movie movieResult = changeMovieStatusWhenReturn(nameMovie);
        if (movieResult != null && !movieResult.isMovieCheckout()){
            return Messages.SUCCESSFUL_RETURN_MOVIE.toString();
        }
        return Messages.UNSUCCESSFUL_RETURN_MOVIE.toString();
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

    private Movie changeMovieStatusWhenReturn(String nameMovie) {
        for (Movie movie : moviesInLibrary) {
            if (movie.getName().equals(nameMovie)) {
                movie.setMovieIsCheckedOut(false);
                return movie;
            }
        }
        return null;
    }

    public String checkoutBook(String nameBook) {
        return messageFromCheckoutBook(nameBook);
    }

    public String checkoutMovie(String nameMovie) {
        return messageFromCheckoutMovie(nameMovie);
    }

    public String returnBook(String nameBook) {
        return messageFromReturnBook(nameBook);
    }

    public String returnMovie(String nameMovie) {
        return messageFromReturnMovie(nameMovie);
    }

    public String messageWhenQuitLibrary(){
        return MenuOptions.QUIT.nameOption();
    }

    public String messageToSelectValidOption(){
        return MenuOptions.NOT_VALID_OPTION.nameOption();
    }
}
