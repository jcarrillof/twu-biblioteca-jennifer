package com.twu.biblioteca;

public abstract class Item {

    private String userWhoCheckedOut;

    public abstract String getName();

    public abstract String itemDetails();

    public abstract void setItemCheckedOut(boolean bookIsCheckedOut, String userResponsible);

    public abstract boolean isItemCheckedOut();

    public void setUserWhoCheckedOut(String userWhoCheckedOut){
        this.userWhoCheckedOut = userWhoCheckedOut;
    }

    public String getUserWhoCheckedOut() {
        return userWhoCheckedOut;
    }
}
