package com.twu.biblioteca;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library = new Library();

    @Test
    public void shouldReturnStringOfListOfBooksAvailable() {
        List<Book> listBooks = library.booksInLibrary;
        String expected = "\n";
        for (Book book : listBooks) {
            if (!book.isBookCheckout()){
                expected += book.bookDetails();
            }
        }
        assertEquals(expected, library.listAvailableBooks());
    }

    @Test
    public void shouldReturnStringOfListOfMoviesAvailable() {
        List<Movie> listMovies = library.moviesInLibrary;
        String expected = "\n";
        for (Movie movie : listMovies) {
            if (!movie.isMovieCheckout()){
                expected += movie.movieDetails();
            }
        }
        assertEquals(expected, library.listAvailableMovies());
    }

    @Test
    public void shouldReturnMessageWhenBookExistsAndIsAvailable() {
        String nameBook = library.booksInLibrary.get(0).getName();
        String messageWhenCheckoutBook = library.checkoutBook(nameBook);
        assertEquals("Thank you! Enjoy the book", messageWhenCheckoutBook);
    }

    @Test
    public void shouldReturnMessageWhenBookDoesNotExist(){
        String nameBook = "Book Five";
        String messageWhenCheckoutBook = library.checkoutBook(nameBook);
        assertEquals("That book is not available", messageWhenCheckoutBook);
    }

    @Test
    public void shouldReturnMessageWhenBookIsNotAvailable(){
        Book book = library.booksInLibrary.get(1);
        book.setBookIsCheckedOut(true);
        String nameBook = book.getName();
        String messageWhenCheckoutBook = library.checkoutBook(nameBook);
        assertEquals("That book is not available", messageWhenCheckoutBook);
    }

    @Test
    public void shouldReturnMessageWhenMovieExistsAndIsAvailable() {
        String nameMovie = library.moviesInLibrary.get(0).getName();
        String messageWhenCheckoutMovie = library.checkoutMovie(nameMovie);
        assertEquals("Thank you! Enjoy the movie", messageWhenCheckoutMovie);
    }

    @Test
    public void shouldReturnMessageWhenMovieDoesNotExist() {
        String nameMovie = "Movie Five";
        String messageWhenCheckoutMovie = library.checkoutMovie(nameMovie);
        assertEquals("That movie is not available", messageWhenCheckoutMovie);
    }

    @Test
    public void shouldReturnMessageWhenMovieIsNotAvailable(){
        Movie movie = library.moviesInLibrary.get(1);
        movie.setMovieIsCheckedOut(true);
        String nameMovie = movie.getName();
        String messageWhenCheckoutMovie = library.checkoutMovie(nameMovie);
        assertEquals("That movie is not available", messageWhenCheckoutMovie);
    }

    @Test
    public void shouldReturnMessageWhenSuccessfulReturnBook() {
        String nameBook = library.booksInLibrary.get(0).getName();
        String messageWhenReturnBook = library.returnBook(nameBook);
        assertEquals("Thank you for returning the book", messageWhenReturnBook);
    }

    @Test
    public void shouldReturnMessageWhenUnsuccessfulReturnBook() {
        String nameBook = "Book Five";
        String messageWhenReturnBook = library.returnBook(nameBook);
        assertEquals("That is not a valid book to return", messageWhenReturnBook);
    }

    @Test
    public void shouldReturnMessageWhenSuccessfulReturnMovie() {
        String nameMovie = library.moviesInLibrary.get(0).getName();
        String messageWhenReturnMovie = library.returnMovie(nameMovie);
        assertEquals("Thank you for returning the movie", messageWhenReturnMovie);
    }

    @Test
    public void shouldReturnMessageWhenUnSuccessfulReturnMovie() {
        String nameMovie = "Movie Five";
        String messageWhenReturnMovie = library.returnMovie(nameMovie);
        assertEquals("That is not a valid movie to return", messageWhenReturnMovie);
    }
}