package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        Login login = new Login();
        login.getInputCredentials();

        String resultFromAction;
        String nameItem = "";
        Menu menu = new Menu();
        menu.printWelcomeMessage();

        do {
            menu.printMenu();
            String inputFromUser = menu.readInputFromKeyboard();
            int optionNumber = menu.numberOptionFromInputString(inputFromUser);
            if (optionNumber == MenuOptions.CHECKOUT_BOOK.numberOption()
                    || optionNumber == MenuOptions.RETURN_BOOK.numberOption()){
                nameItem = menu.getNameItemFromInput();
            }
            resultFromAction = menu.doActionFromOption(optionNumber, nameItem);
            System.out.println(resultFromAction);
        }while (!resultFromAction.equals(MenuOptions.QUIT.nameOption()));
    }
}