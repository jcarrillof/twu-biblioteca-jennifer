package com.twu.domain;

public abstract class Item {

    public abstract String getName();

    public abstract String itemDetails();

    public abstract void setItemCheckedOut(boolean bookIsCheckedOut, String userResponsible);

    public abstract boolean isItemCheckedOut();
}
