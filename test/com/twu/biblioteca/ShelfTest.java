package com.twu.biblioteca;

import com.twu.dominio.Book;
import com.twu.dominio.Movie;
import com.twu.dominio.User;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class ShelfTest {

    private User user = new User("001-0010", "user_pass", "Jennifer", "jen@gmail.com", "0985357367");

    @Test
    public void shouldPrintListOfAvailableItems() {
        Shelf<Book> bookShelf= new Shelf<>();
        bookShelf.add(new Book("New book","New author",0));
        String expected = "\n";
        List<Item> listOfItems = bookShelf.itemsInShelf;
        for (Item item:listOfItems) {
            if (!item.isItemCheckedOut()){
                expected += item.itemDetails();
            }
        }
        assertEquals(expected, bookShelf.listAvailableItems());
    }

    @Test
    public void shouldReturnMessageWhenItemExistsAndIsAvailable() {
        Shelf<Movie> movieShelf= new Shelf<>();
        movieShelf.add(new Movie("New movie",0,"New director"));
        String nameBook = movieShelf.itemsInShelf.get(0).getName();
        String messageWhenCheckoutItem = movieShelf.checkoutItem(nameBook, user);
        assertEquals("Thank you! Enjoy the movie", messageWhenCheckoutItem);
    }

    @Test
    public void shouldReturnMessageWhenItemDoesNotExist(){
        Shelf<Book> bookShelf= new Shelf<>();
        String nameBook = "Book Five";
        String messageWhenCheckoutBook = bookShelf.checkoutItem(nameBook, user);
        assertEquals("That item is not available", messageWhenCheckoutBook);
    }

    @Test
    public void shouldReturnMessageWhenItemIsNotAvailable(){
        Shelf<Movie> movieShelf= new Shelf<>();
        movieShelf.add(new Movie("New movie",0,"New director"));
        Item movie = movieShelf.itemsInShelf.get(0);
        movie.setItemCheckedOut(true, null);
        String nameMovie = movie.getName();
        String messageWhenCheckoutBook = movieShelf.checkoutItem(nameMovie, null);
        assertEquals("That item is not available", messageWhenCheckoutBook);
    }

    @Test
    public void shouldReturnMessageWhenSuccessfulReturnBook() {
        Shelf<Book> bookShelf= new Shelf<>();
        bookShelf.add(new Book("New book", "New author", 0));
        String nameBook = bookShelf.itemsInShelf.get(0).getName();
        String messageWhenReturnBook = bookShelf.returnItem(nameBook);
        assertEquals("Thank you for returning the item", messageWhenReturnBook);
    }

    @Test
    public void shouldReturnMessageWhenUnsuccessfulReturnBook() {
        Shelf<Movie> movieShelf= new Shelf<>();
        String nameMovie = "Movie Five";
        String messageWhenReturnMovie = movieShelf.returnItem(nameMovie);
        assertEquals("That is not a valid item to return", messageWhenReturnMovie);
    }
}