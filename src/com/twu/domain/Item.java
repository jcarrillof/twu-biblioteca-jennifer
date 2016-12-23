package com.twu.domain;

public interface Item {

    String getName();
    String itemDetails();
    void setItemCheckedOut(boolean bookIsCheckedOut, String userResponsible);
    boolean isItemCheckedOut();
}
