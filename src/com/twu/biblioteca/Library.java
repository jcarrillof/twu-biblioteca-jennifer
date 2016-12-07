package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<Book> booksInLibrary = new ArrayList<>();
    private Menu menu = new Menu();
    private PrintStream printStream;

    public Library(PrintStream printStream) {
        this.printStream = printStream;

        Book bookOne = new Book("Book One", "Author One", "2016");
        bookOne.setBookIsCheckedOut(false);
        booksInLibrary.add(bookOne);

        Book bookTwo = new Book("Book Two", "Author Two", "2017");
        bookTwo.setBookIsCheckedOut(true);
        booksInLibrary.add(bookTwo);
    }

    public void printWelcomeMessage(){
        printStream.println("Welcome to Library!");
    }

    public void printMenu(){
        printStream.println(menu.getMenu());
    }

    public String readInputFromKeyboard(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void actionFromInputOption(String inputSelectedOption){
        menu.actionFromSelectedOption(inputSelectedOption, booksInLibrary);
    }
}
