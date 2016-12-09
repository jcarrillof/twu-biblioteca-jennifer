package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
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
}
