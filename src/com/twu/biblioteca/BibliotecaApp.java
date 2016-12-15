package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        String resultFromAction;
        String nameBook = "";
        Menu menu = new Menu();
        menu.printWelcomeMessage();

        do {
            menu.printMenu();
            String inputFromUser = menu.readInputFromKeyboard();
            int optionNumber = menu.numberOptionFromInputString(inputFromUser);
            if (optionNumber == MenuOptions.CHECKOUT_BOOK.numberOption()
                    || optionNumber == MenuOptions.RETURN_BOOK.numberOption()){
                nameBook = menu.getNameBookFromInput();
            }
            resultFromAction = menu.doActionFromOption(optionNumber, nameBook);
            System.out.println(resultFromAction);
        }while (!resultFromAction.equals(MenuOptions.QUIT.nameOption()));
    }
}