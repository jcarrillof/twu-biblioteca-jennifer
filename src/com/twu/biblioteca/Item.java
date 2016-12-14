package com.twu.biblioteca;

public abstract class Item {
    private boolean itemIsCheckedOut;

    Item() {
        setItemIsCheckedOut(false);
    }

    public void setItemIsCheckedOut(boolean itemIsCheckedOut) {
        this.itemIsCheckedOut = itemIsCheckedOut;
    }

    public boolean itemIsCheckedOut() {
        return itemIsCheckedOut;
    }

    public abstract String getName();

    public abstract String itemDetails();
}
