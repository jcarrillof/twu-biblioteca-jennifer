package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void shouldReturnOptionOneFromMenu() {
        Menu menu = new Menu();
        String optionFromMenu = "1";

        String optionSelectedFromMenu = menu.selectedOption(optionFromMenu);

        assertEquals("1", optionSelectedFromMenu);
    }

    @Test
    public void shouldReturnMessageWhenOptionNotIncludedInMenu() throws Exception {
        Menu menu = new Menu();
        String optionFromMenu = "100";

        String optionSelectedNotInMenu = menu.selectedOption(optionFromMenu);

        assertEquals("Select a valid option!", optionSelectedNotInMenu);
    }

    @Test
    public void shouldReturnMessageWhenInputIsTrashString() {
        Menu menu = new Menu();
        String optionFromMenu = "It is a string";

        String optionSelectedNotInMenu = menu.selectedOption(optionFromMenu);

        assertEquals("Select a valid option!", optionSelectedNotInMenu);
    }

    @Test
    public void shouldQuitWhenInputIsZero() {
        Menu menu = new Menu();
        String optionFromMenu = "0";

        String optionSelectFromMenu = menu.selectedOption(optionFromMenu);

        assertEquals("Quit", optionSelectFromMenu);
    }

}
