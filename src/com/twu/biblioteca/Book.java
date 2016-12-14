package com.twu.biblioteca;

public class Book extends Item{

    private String name;
    private String author;
    private int yearPublished;

    Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        setItemIsCheckedOut(false);
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
}
