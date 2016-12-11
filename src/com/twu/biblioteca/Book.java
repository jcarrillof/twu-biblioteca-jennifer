package com.twu.biblioteca;

public class Book {

    private String name;
    private String author;
    private int yearPublished;
    private boolean bookIsCheckedOut;

    Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.bookIsCheckedOut = false;
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

    public String bookDetails(){
        return String.format("%-30s%-30s%-4d\n", name, author, yearPublished);
    }

    public void setBookIsCheckedOut(boolean bookIsCheckedOut) {
        this.bookIsCheckedOut = bookIsCheckedOut;
    }

    public boolean bookIsCheckedOut() {
        return bookIsCheckedOut;
    }
}
