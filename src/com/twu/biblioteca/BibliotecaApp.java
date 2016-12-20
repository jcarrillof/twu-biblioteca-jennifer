package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        final int userNull = -1;
        String resultFromAction;
        String nameItem = "";
        Menu menu = new Menu();
        menu.printWelcomeMessage();
        int user = userNull;

        do {
            menu.printMenu();
            String inputFromUser = menu.readInputFromKeyboard();
            int optionNumber = menu.numberOptionFromInputString(inputFromUser);
            if (optionNumber == MenuOptions.CHECKOUT_BOOK.numberOption()
                    || optionNumber == MenuOptions.RETURN_BOOK.numberOption()){

                List<String> credentials = menu.getInputCredentials();
                user = menu.validateCredentials(credentials);
                if(user != userNull){
                    nameItem = menu.getNameItemFromInput();
                }
            }else if (optionNumber == MenuOptions.CHECKOUT_MOVIE.numberOption()
                    || optionNumber == MenuOptions.RETURN_MOVIE.numberOption()){
                nameItem = menu.getNameItemFromInput();
            }else if (optionNumber == MenuOptions.USER_INFORMATION.numberOption()){
                List<String> credentials = menu.getInputCredentials();
                user = menu.validateCredentials(credentials);
            }
            resultFromAction = menu.doActionFromOption(optionNumber, nameItem, user);
            System.out.println(resultFromAction);
        }while (!resultFromAction.equals(MenuOptions.QUIT.nameOption()));
    }
}