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
                + "1. List of books\n" + "2. Check-out books\n"
                + "3. Return book\n" + "0. Quit\n"
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
    public void shouldReturnStringOneFromInputKeyboard() {
        String expected = "1";
        Menu menu = new Menu();
        assertEquals(expected, menu.readInputFromKeyboard());
    }
}
