package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    private Item item = new Item() {
        @Override
        public String getName() {
            return null;
        }

        @Override
        public String itemDetails() {
            return null;
        }
    };

    @Test
    public void shouldSetCheckoutFalseWhenBookIsCreated() {
        assertFalse(item.itemIsCheckedOut());
    }

    @Test
    public void shouldReturnTrueWhenItemIsCheckedOut() {
        item.setItemIsCheckedOut(true);
        assertTrue(item.itemIsCheckedOut());
    }

    @Test
    public void shouldReturnFalseWhenItemIsNotCheckedOut() {
        item.setItemIsCheckedOut(false);
        assertFalse(item.itemIsCheckedOut());
    }
}