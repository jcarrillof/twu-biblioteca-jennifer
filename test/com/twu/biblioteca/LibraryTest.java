package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {

    private Library library;
    private List<Book> booksInLibrary = new ArrayList<>();

    @Mock
    private PrintStream printStream;

    @Before
    public void setUp() {
        library = new Library(printStream);

        Book bookOne = new Book("Book One", "Author One", "2016");
        bookOne.setBookIsCheckedOut(false);
        booksInLibrary.add(bookOne);

        Book bookTwo = new Book("Book Two", "Author Two", "2017");
        bookTwo.setBookIsCheckedOut(true);
        booksInLibrary.add(bookTwo);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        library.printWelcomeMessage();
        verify(printStream).println("Welcome to Library!");
    }

    @Test
    public void shouldPrintMenu() {
        library.printMenu();
        Menu menu = new Menu();
        verify(printStream).println(menu.getMenu());
    }

    @Test
    public void shouldReturnOptionOneFromMenu() {
        String optionFromMenu = "1";
        String expected = "";
        for (Book book : booksInLibrary) {
            if (!book.bookIsCheckedOut()) {
                expected += (book.bookDetails() + "\n");
            }
        }

        String optionSelectedFromMenu = library.actionFromInputOption(optionFromMenu);
        assertEquals(expected, optionSelectedFromMenu);
    }

    @Test
    public void shouldReturnMessageWhenOptionNotIncludedInMenu() {
        String optionFromMenu = "100";

        String optionSelectedNotInMenu = library.actionFromInputOption(optionFromMenu);
        assertEquals("Select a valid option!", optionSelectedNotInMenu);
    }

    @Test
    public void shouldQuitWhenInputIsZero() {
        String optionFromMenu = "0";

        String optionSelectFromMenu = library.actionFromInputOption(optionFromMenu);
        assertEquals("Quit", optionSelectFromMenu);
    }

    @Test
    public void shouldReturnMessageWhenBookExistsAndIsAvailable() {
        String nameBook = "Book One";

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
        String nameBook = "Book Two";

        String messageWhenCheckoutBook = library.checkoutBook(nameBook);
        assertEquals("That book is not available", messageWhenCheckoutBook);
    }

    @Test
    public void shouldReturnMessageWhenSuccessfulReturn() {
        String nameBook = "Book Two";

        String messageWhenReturnBook = library.returnBook(nameBook);
        assertEquals("Thank you for returning the book", messageWhenReturnBook);
    }

    @Test
    public void shouldReturnMessageWhenUnsuccessfulReturn() {
        String nameBook = "Book Five";

        String messageWhenReturnBook = library.returnBook(nameBook);
        assertEquals("That is not a valid book to return", messageWhenReturnBook);
    }
}