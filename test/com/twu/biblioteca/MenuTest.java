package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MenuTest {

    private Menu menu = new Menu();
    private List<Book> booksInLibrary = new ArrayList<>();

    @Before
    public void setUp() {
        Book bookOne = new Book("Book One", "Author One", "2016");
        bookOne.setBookIsCheckedOut(false);
        booksInLibrary.add(bookOne);

        Book bookTwo = new Book("Book Two", "Author Two", "2017");
        bookTwo.setBookIsCheckedOut(true);
        booksInLibrary.add(bookTwo);
    }

    @Test
    public void shouldReturnOptionOneFromMenu() {
        String optionFromMenu = "1";

        String optionSelectedFromMenu = menu.actionFromSelectedOption(optionFromMenu, booksInLibrary);
        assertEquals("", optionSelectedFromMenu);
    }

    @Test
    public void shouldReturnMessageWhenOptionNotIncludedInMenu() {
        String optionFromMenu = "100";

        String optionSelectedNotInMenu = menu.actionFromSelectedOption(optionFromMenu, booksInLibrary);
        assertEquals("Select a valid option!", optionSelectedNotInMenu);
    }

    @Test
    public void shouldQuitWhenInputIsZero() {
        String optionFromMenu = "0";

        String optionSelectFromMenu = menu.actionFromSelectedOption(optionFromMenu, booksInLibrary);
        assertEquals("Quit", optionSelectFromMenu);
    }

    @Test
    public void shouldReturnMessageWhenBookExistsAndIsAvailable() {
        String nameBook = "Book One";

        String messageWhenCheckoutBook = menu.checkoutBook(nameBook, booksInLibrary);
        assertEquals("Thank you! Enjoy the book", messageWhenCheckoutBook);
    }

    @Test
    public void shouldReturnMessageWhenBookDoesNotExist() {
        String nameBook = "Book Five";

        String messageWhenCheckoutBook = menu.checkoutBook(nameBook, booksInLibrary);
        assertEquals("That book is not available", messageWhenCheckoutBook);
    }

    @Test
    public void shouldReturnMessageWhenBookIsNotAvailable(){
        String nameBook = "Book Two";

        String messageWhenCheckoutBook = menu.checkoutBook(nameBook, booksInLibrary);
        assertEquals("That book is not available", messageWhenCheckoutBook);
    }

    @Test
    public void shouldReturnMessageWhenSuccessfulReturn() {
        String nameBook = "Book Two";

        String messageWhenReturnBook = menu.returnBook(nameBook, booksInLibrary);
        assertEquals("Thank you for returning the book", messageWhenReturnBook);
    }

    @Test
    public void shouldReturnMessageWhenUnsuccessfulReturn() {
        String nameBook = "Book Five";

        String messageWhenReturnBook = menu.returnBook(nameBook, booksInLibrary);
        assertEquals("That is not a valid book to return", messageWhenReturnBook);
    }

}
