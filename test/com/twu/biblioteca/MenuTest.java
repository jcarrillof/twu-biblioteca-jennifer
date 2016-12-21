package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    @Test
    public void shouldPrintWelcomeMessage(){
        PrintStream printStream = mock(PrintStream.class);
        Menu menu = new Menu(printStream);
        menu.printWelcomeMessage();
        verify(printStream).println("Welcome to Library!");
    }

    @Test
    public void shouldPrintMenu() {
        String menuString = "\n/***** Menu *****/\n"
                + MenuOptions.LOG_IN.toString()
                + MenuOptions.LIST_OF_BOOKS.toString()
                + MenuOptions.CHECKOUT_BOOK.toString() + MenuOptions.RETURN_BOOK.toString()
                + MenuOptions.LIST_OF_MOVIES.toString()
                + MenuOptions.CHECKOUT_MOVIE.toString() + MenuOptions.RETURN_MOVIE.toString()
                + MenuOptions.USER_INFORMATION.toString()
                + MenuOptions.USERS_WHO_CHECKOUT_BOOKS.toString()
                + MenuOptions.LOG_OUT.toString()
                + MenuOptions.QUIT.toString()
                + "\nSelect an option: ";
        PrintStream printStream = mock(PrintStream.class);
        Menu menu = new Menu(printStream);
        menu.printMenu();
        verify(printStream).println(menuString);
    }

    @Test
    public void shouldReturnOptionOneWhenInputStringIsOne() {
        String inputString = "1";
        Menu menu = new Menu();
        int numberOption = menu.numberOptionFromInputString(inputString);
        assertEquals(1, numberOption);
    }

    @Test
    public void shouldReturnNegativeNumberOneWhenInputStringIsNotValid() {
        String inputString = "Not valid string";
        Menu menu = new Menu();
        int numberOption = menu.numberOptionFromInputString(inputString);
        assertEquals(-1, numberOption);
    }

    @Test
    public void shouldReturnNegativeNumberOneWhenInputNumberIsNotInMenu(){
        String inputString = "100";
        Menu menu = new Menu();
        int numberOption = menu.numberOptionFromInputString(inputString);
        assertEquals(-1, numberOption);
    }

    @Test
    public void shouldReturnBookListWhenGivenOptionOne() {
        int optionFromMenu = 2;
        String nameBook = "";
        Menu menu = new Menu();
        Library library = new Library();
        String booksAvailableExpected = library.listAvailableBooks();
        assertEquals(booksAvailableExpected, menu.doActionFromOption(optionFromMenu, nameBook, null));
    }

    @Test
    public void shouldReturnQuitWhenGivenOptionZero() {
        int optionFromMenu = 0;
        String nameBook = "";
        Menu menu = new Menu();
        assertEquals("Quit", menu.doActionFromOption(optionFromMenu, nameBook, null));
    }

    @Test
    public void shouldReturnMessageWhenGivenOptionNotFoundInMenu() {
        int optionFromMenu = 100;
        String nameBook = "";
        Menu menu = new Menu();
        assertEquals("Action not found!", menu.doActionFromOption(optionFromMenu, nameBook, null));
    }
}
