package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    private Book bookOne = new Book("Book One", "Author One", "2016");
    private Book bookTwo = new Book("Book Two", "Author Two", "2017");

    @Test
    public void shouldReturnFirstBookNameWhenCreated(){
        assertEquals("Book One", bookOne.name);
    }

    @Test
    public void shouldReturnSecondBookNameWhenCreated() {
        assertEquals("Book Two", bookTwo.name);
    }

    @Test
    public void shouldReturnFirstBookAuthorWhenCreated() {
        assertEquals("Author One", bookOne.author);
    }

    @Test
    public void shouldReturnSecondBookAuthorWhenCreated() {
        assertEquals("Author Two", bookTwo.author);
    }

    @Test
    public void shouldReturnFirstBookYearPublishedWhenCreated() {
        assertEquals("2016", bookOne.yearPublished);
    }

    @Test
    public void shouldReturnSecondBookYearPublishedWhenCreated() {
        assertEquals("2017", bookTwo.yearPublished);
    }

    @Test
    public void shouldReturnStringOfFirstBookDetails(){
        String expected = String.format("%-30s%-30s%-4s\n","Book One", "Author One", "2016");
        assertEquals(expected, bookOne.toString());
    }

    @Test
    public void shouldReturnStringOfSecondBookDetails() {
        String expected = String.format("%-30s%-30s%-4s\n","Book Two", "Author Two", "2017");
        assertEquals(expected, bookTwo.toString());
    }
}
