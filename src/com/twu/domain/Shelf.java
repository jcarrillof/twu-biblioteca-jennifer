package com.twu.domain;

import com.twu.resources.Messages;

import java.util.ArrayList;
import java.util.List;

public class Shelf<T extends Item> {

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

    public String checkoutItem(String nameItem, User userWhoCheckOutItemWhenNeeded) {
        return messageFromCheckoutItem(nameItem, userWhoCheckOutItemWhenNeeded);
    }

    private String messageFromCheckoutItem(String nameItem, User userWhoCheckOutItemWhenNeeded) {
        Item itemResult = changeItemStatusWhenCheckout(nameItem, userWhoCheckOutItemWhenNeeded);
        if (itemResult != null && itemResult.isItemCheckedOut() && itemResult instanceof Book){
            return Messages.SUCCESSFUL_CHECKOUT_BOOK.toString();
        }else if(itemResult != null && itemResult.isItemCheckedOut() && itemResult instanceof Movie){
            return Messages.SUCCESSFUL_CHECKOUT_MOVIE.toString();
        }
        return Messages.UNSUCCESSFUL_CHECKOUT_ITEM.toString();
    }

    private Item changeItemStatusWhenCheckout(String nameItem, User userWhoCheckOutItemWhenNeeded) {
        for (Item item : itemsInShelf) {
            if(item.getName().equals(nameItem) && !item.isItemCheckedOut()){
                if(userWhoCheckOutItemWhenNeeded == null){
                    item.setItemCheckedOut(true, null);
                }else {
                    item.setItemCheckedOut(true, userWhoCheckOutItemWhenNeeded.getName());
                }
                return item;
            }
        }
        return null;
    }

    public String returnItem(String nameItem) {
        return messageFromReturnItem(nameItem);
    }

    private String messageFromReturnItem(String nameItem) {
        Item itemResult = changeItemStatusWhenReturn(nameItem);
        if (itemResult != null && !itemResult.isItemCheckedOut()){
            return Messages.SUCCESSFUL_RETURN_ITEM.toString();
        }
        return Messages.UNSUCCESSFUL_RETURN_ITEM.toString();
    }

    private Item changeItemStatusWhenReturn(String nameItem) {
        for (Item item : itemsInShelf) {
            if (item.getName().equals(nameItem)) {
                item.setItemCheckedOut(false, null);
                return item;
            }
        }
        return null;
    }
}
