package com.twu.biblioteca;

import com.twu.dominio.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library = new Library();
    private User user = new User("001-0010", "user_pass", "Jennifer", "jen@gmail.com", "0985357367");

    @Test
    public void shouldReturnStringOfListOfItemsAvailable() {
        String expected = "\n";
        List<Item> listOfItems = library.bookShelf.itemsInShelf;
        for (Item item:listOfItems) {
            if (!item.isItemCheckedOut()){
                expected += item.itemDetails();
            }
        }
        assertEquals(expected, library.listAvailableBooks());
    }

    @Test
    public void shouldReturnStringOfListOfMoviesAvailable() {
        List<Item> listMovies = library.movieShelf.itemsInShelf;
        String expected = "\n";
        for (Item movie : listMovies) {
            if (!movie.isItemCheckedOut()){
                expected += movie.itemDetails();
            }
        }
        assertEquals(expected, library.listAvailableMovies());
    }

    @Test
    public void shouldReturnMessageWhenBookExistsAndIsAvailable() {
        String nameBook = library.bookShelf.itemsInShelf.get(0).getName();
        String messageWhenCheckoutBook = library.checkoutBook(nameBook, user);
        assertEquals("Thank you! Enjoy the book", messageWhenCheckoutBook);
    }

    @Test
    public void shouldReturnMessageWhenBookDoesNotExist(){
        String nameBook = "Book Five";
        String messageWhenCheckoutBook = library.checkoutBook(nameBook, user);
        assertEquals("That item is not available", messageWhenCheckoutBook);
    }

    @Test
    public void shouldReturnMessageWhenBookIsNotAvailable(){
        Item book = library.bookShelf.itemsInShelf.get(1);
        book.setItemCheckedOut(true, "New user");
        String nameBook = book.getName();
        String messageWhenCheckoutBook = library.checkoutBook(nameBook, user);
        assertEquals("That item is not available", messageWhenCheckoutBook);
    }

    @Test
    public void shouldReturnMessageWhenMovieExistsAndIsAvailable() {
        String nameMovie = library.movieShelf.itemsInShelf.get(0).getName();
        String messageWhenCheckoutMovie = library.checkoutMovie(nameMovie);
        assertEquals("Thank you! Enjoy the movie", messageWhenCheckoutMovie);
    }

    @Test
    public void shouldReturnMessageWhenMovieDoesNotExist() {
        String nameMovie = "Movie Five";
        String messageWhenCheckoutMovie = library.checkoutMovie(nameMovie);
        assertEquals("That item is not available", messageWhenCheckoutMovie);
    }

    @Test
    public void shouldReturnMessageWhenMovieIsNotAvailable(){
        Item movie = library.movieShelf.itemsInShelf.get(1);
        movie.setItemCheckedOut(true, null);
        String nameMovie = movie.getName();
        String messageWhenCheckoutMovie = library.checkoutMovie(nameMovie);
        assertEquals("That item is not available", messageWhenCheckoutMovie);
    }

    @Test
    public void shouldReturnMessageWhenSuccessfulReturnBook() {
        String nameBook = library.bookShelf.itemsInShelf.get(0).getName();
        String messageWhenReturnBook = library.returnBook(nameBook);
        assertEquals("Thank you for returning the item", messageWhenReturnBook);
    }

    @Test
    public void shouldReturnMessageWhenUnsuccessfulReturnBook() {
        String nameBook = "Book Five";
        String messageWhenReturnBook = library.returnBook(nameBook);
        assertEquals("That is not a valid item to return", messageWhenReturnBook);
    }

    @Test
    public void shouldReturnMessageWhenSuccessfulReturnMovie() {
        String nameMovie = library.movieShelf.itemsInShelf.get(0).getName();
        String messageWhenReturnMovie = library.returnMovie(nameMovie);
        assertEquals("Thank you for returning the item", messageWhenReturnMovie);
    }

    @Test
    public void shouldReturnMessageWhenUnSuccessfulReturnMovie() {
        String nameMovie = "Movie Five";
        String messageWhenReturnMovie = library.returnMovie(nameMovie);
        assertEquals("That is not a valid item to return", messageWhenReturnMovie);
    }

    @Test
    public void shouldReturnStringOfCheckedOutBooksWithResponsible() {
        List<Item> listBooks = library.bookShelf.itemsInShelf;
        library.checkoutBook(listBooks.get(0).getName(), user);
        String expected = "\n";
        for (Item book : listBooks) {
            if (book.isItemCheckedOut()){
                expected += book.getUserWhoCheckedOut() + " -- " + book.getName() + "\n";
            }
        }
        assertEquals(expected, library.listCheckedOutItems());
    }

    @Test
    public void shouldReturnNullUserWhenBookReturn() {
        List<Item> listBooks = library.bookShelf.itemsInShelf;
        library.returnBook(listBooks.get(0).getName());
        Item bookTest = listBooks.get(0);
        assertEquals(null, bookTest.getUserWhoCheckedOut());
    }
}