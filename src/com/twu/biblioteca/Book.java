package com.twu.biblioteca;

public class Book {

    private String name;
    private String author;
    private String yearPublished;
    private boolean bookIsCheckedOut;

    Book(String name, String author, String yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public String bookDetails(){
        return String.format("%-30s%-30s%-4s\n", name, author, yearPublished);
    }

    public void setBookIsCheckedOut(boolean bookIsCheckedOut) {
        this.bookIsCheckedOut = bookIsCheckedOut;
    }

    public boolean bookIsCheckedOut() {
        return bookIsCheckedOut;
    }
}
