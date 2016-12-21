package com.twu.biblioteca;

import com.twu.dominio.Book;

import java.util.ArrayList;
import java.util.List;

public class Shelf<T> {

    public List<Item> itemsInShelf = new ArrayList<>();

    public String listAvailableItems() {
        String printFormat = "\n";
        for (Item item:itemsInShelf) {
            if (!item.isItemCheckedOut()){
                printFormat += item.itemDetails();
            }
        }
        return printFormat;
    }

    public void add(T item) {
        itemsInShelf.add((Item) item);
    }
}
