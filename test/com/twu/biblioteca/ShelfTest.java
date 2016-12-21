package com.twu.biblioteca;

import com.twu.dominio.Book;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class ShelfTest {

    @Test
    public void shouldPrintListOfAvailableItems() {
        Shelf<Book> bookShelf= new Shelf<>();
        bookShelf.add(new Book("New book","New author",0));
        String expected = "\n";
        List<Item> listOfItems = bookShelf.itemsInShelf;
        for (Item item:listOfItems) {
            if (!item.isItemCheckedOut()){
                expected += item.itemDetails();
            }
        }
        assertEquals(expected, bookShelf.listAvailableItems());
    }
}