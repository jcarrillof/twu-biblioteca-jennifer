package com.twu.domain;

public class Book extends Item {

    private String name;
    private String author;
    private int yearPublished;
    private boolean bookIsCheckedOut;
    private String userWhoCheckedOut;

    public Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        setItemCheckedOut(false, null);
    }

    @Override
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    @Override
    public String itemDetails() {
        return String.format("%-30s%-30s%-4d\n", name, author, yearPublished);
    }

    @Override
    public boolean isItemCheckedOut() {
        return bookIsCheckedOut;
    }

    @Override
    public void setItemCheckedOut(boolean bookIsCheckedOut, String userResponsible) {
        this.bookIsCheckedOut = bookIsCheckedOut;
        if (!bookIsCheckedOut){
            setUserWhoCheckedOut(null);
        }else {
            setUserWhoCheckedOut(userResponsible);
        }
    }

    public void setUserWhoCheckedOut(String userWhoCheckedOut){
        this.userWhoCheckedOut = userWhoCheckedOut;
    }

    public String getUserWhoCheckedOut() {
        return userWhoCheckedOut;
    }
}
