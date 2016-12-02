package com.twu.biblioteca;


public class Book {

    String name;
    String author;
    String yearPublished;

    Book(String name, String author, String yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String toString(){
        return String.format("%-30s%-30s%-4s\n", name, author, yearPublished);
    }
}
