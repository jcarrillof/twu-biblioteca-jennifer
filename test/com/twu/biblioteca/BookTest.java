package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    private Book bookOne = new Book("Book One", "Author One", 2016);

    @Test
    public void shouldReturnBookNameWhenCreated(){
        assertEquals("Book One", bookOne.getName());
    }

    @Test
    public void shouldReturnBookAuthorWhenCreated() {
        assertEquals("Author One", bookOne.getAuthor());
    }

    @Test
    public void shouldReturnBookYearPublishedWhenCreated() {
        assertEquals(2016, bookOne.getYearPublished());
    }

    @Test
    public void shouldReturnStringOfBookDetails(){
        String expected = String.format("%-30s%-30s%-4s\n","Book One", "Author One", 2016);
        assertEquals(expected, bookOne.bookDetails());
    }

    @Test
    public void shouldSetCheckoutFalseWhenBookIsCreated() {
        assertFalse(bookOne.isBookCheckout());
    }

    @Test
    public void shouldReturnTrueWhenBookIsCheckedOut() {
        bookOne.setBookIsCheckedOut(true);
        assertTrue(bookOne.isBookCheckout());
    }

    @Test
    public void shouldReturnFalseWhenBookIsNotCheckedOut() {
        bookOne.setBookIsCheckedOut(false);
        assertFalse(bookOne.isBookCheckout());
    }
}
