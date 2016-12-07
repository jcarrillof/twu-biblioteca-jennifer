package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.io.PrintStream;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {

    private Library library;
    @Mock
    private PrintStream printStream;

    @Before
    public void setUp() {
        library = new Library(printStream);
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
}
