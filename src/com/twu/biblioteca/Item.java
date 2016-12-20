package com.twu.biblioteca;

public abstract class Item {

    private String userResponsible;

    public abstract void setItemCheckedOut(boolean bookIsCheckedOut, String userResponsible);

    public abstract boolean isItemCheckedOut();

    public void setResponsibleUser(String userResponsible){
        this.userResponsible = userResponsible;
    }

    public String getResponsibleUser() {
        return userResponsible;
    }
}
