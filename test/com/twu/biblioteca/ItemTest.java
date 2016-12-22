package com.twu.biblioteca;

import com.twu.dominio.Book;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void shouldReturnResponsibleUserWhenCheckoutItem() {
        Item item = new Book("New book", "New author", 2016);
        item.setUserWhoCheckedOut("New user");
        assertEquals("New user", item.getUserWhoCheckedOut());
    }
}
