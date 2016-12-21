package com.twu.biblioteca;

import com.twu.dominio.Book;
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
        assertEquals(expected, bookOne.itemDetails());
    }

    @Test
    public void shouldSetCheckoutFalseWhenBookIsCreated() {
        assertFalse(bookOne.isItemCheckedOut());
    }

    @Test
    public void shouldReturnTrueWhenBookIsCheckedOut() {
        bookOne.setItemCheckedOut(true, "New user");
        assertTrue(bookOne.isItemCheckedOut());
    }

    @Test
    public void shouldReturnFalseWhenBookIsNotCheckedOut() {
        bookOne.setItemCheckedOut(false, null);
        assertFalse(bookOne.isItemCheckedOut());
    }

    @Test
    public void shouldReturnUserNullWhenBookIsReturn() {
        bookOne.setItemCheckedOut(false, null);
        assertEquals(null, bookOne.getResponsibleUser());
    }

    @Test
    public void shouldReturnUserNameWhenBookIsCheckedOut() {
        bookOne.setItemCheckedOut(true, "New user");
        assertEquals("New user", bookOne.getResponsibleUser());
    }
}
