package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library = new Library();

    @Test
    public void shouldReturnMessageWhenBookExistsAndIsAvailable() {
        String nameBook = "Book One";

        String messageWhenCheckoutBook = library.messageFromCheckoutBook(nameBook);
        assertEquals("Thank you! Enjoy the book", messageWhenCheckoutBook);
    }

    @Test
    public void shouldReturnMessageWhenBookDoesNotExist(){
        String nameBook = "Book Five";

        String messageWhenCheckoutBook = library.messageFromCheckoutBook(nameBook);
        assertEquals("That book is not available", messageWhenCheckoutBook);
    }

    @Test
    public void shouldReturnMessageWhenBookIsNotAvailable(){
        String nameBook = "Book Two";

        String messageWhenCheckoutBook = library.messageFromCheckoutBook(nameBook);
        assertEquals("That book is not available", messageWhenCheckoutBook);
    }

    @Test
    public void shouldReturnMessageWhenSuccessfulReturn() {
        String nameBook = "Book Two";

        String messageWhenReturnBook = library.messageFromReturnBook(nameBook);
        assertEquals("Thank you for returning the book", messageWhenReturnBook);
    }

    @Test
    public void shouldReturnMessageWhenUnsuccessfulReturn() {
        String nameBook = "Book Five";

        String messageWhenReturnBook = library.messageFromReturnBook(nameBook);
        assertEquals("That is not a valid book to return", messageWhenReturnBook);
    }
}