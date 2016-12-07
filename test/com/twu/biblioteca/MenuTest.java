package com.twu.biblioteca;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    @Test
    public void shouldReturnMenu() {
        Menu menu = mock(Menu.class);
        menu.getMenu();
        verify(menu).getMenu();
    }
}
