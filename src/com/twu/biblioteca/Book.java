package com.twu.biblioteca;

public class Book extends Item{

    private String name;
    private String author;
    private int yearPublished;
    private boolean bookIsCheckedOut;

    Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        setBookIsCheckedOut(false, null);
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String bookDetails() {
        return String.format("%-30s%-30s%-4d\n", name, author, yearPublished);
    }

    public boolean isBookCheckout() {
        return bookIsCheckedOut;
    }

    public void setBookIsCheckedOut(boolean bookIsCheckedOut, String userResponsible) {
        this.bookIsCheckedOut = bookIsCheckedOut;
        if (!bookIsCheckedOut){
            setResponsibleUser(null);
        }else {
            setResponsibleUser(userResponsible);
        }
    }
}
