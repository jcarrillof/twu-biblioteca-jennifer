package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void shouldReturnResponsibleUserWhenCheckoutItem() {
        Item item = new Item();
        item.setResponsibleUser("New user");
        assertEquals("New user", item.getResponsibleUser());
    }
}
