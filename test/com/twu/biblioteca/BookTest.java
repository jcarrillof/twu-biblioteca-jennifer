package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BookTest {

    private Book bookOne = new Book("Book One", "Author One", "2016");
    private Book bookTwo = new Book("Book Two", "Author Two", "2017");

    @Test
    public void shouldReturnBookNameWhenCreated(){
        assertEquals("Book One", bookOne.getName());
        assertEquals("Book Two", bookTwo.getName());
    }

    @Test
    public void shouldReturnBookAuthorWhenCreated() {
        assertEquals("Author One", bookOne.getAuthor());
        assertEquals("Author Two", bookTwo.getAuthor());
    }

    @Test
    public void shouldReturnBookYearPublishedWhenCreated() {
        assertEquals("2016", bookOne.getYearPublished());
        assertEquals("2017", bookTwo.getYearPublished());
    }

    @Test
    public void shouldReturnStringOfBookDetails(){
        String expected = String.format("%-30s%-30s%-4s\n","Book One", "Author One", "2016");
        assertEquals(expected, bookOne.toString());

        expected = String.format("%-30s%-30s%-4s\n","Book Two", "Author Two", "2017");
        assertEquals(expected, bookTwo.toString());
    }

    @Test
    public void shouldReturnTrueWhenBookIsCheckedOut() {
        bookOne.setBookIsCheckedOut(true);
        assertTrue(bookOne.bookIsCheckedOut());
    }

    @Test
    public void shouldReturnFalseWhenBookIsNotCheckedOut() {
        bookOne.setBookIsCheckedOut(false);
        assertFalse(bookOne.bookIsCheckedOut());
    }
}
