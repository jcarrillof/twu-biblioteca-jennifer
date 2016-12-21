package com.twu.biblioteca;

import com.twu.dominio.User;

import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        String resultFromAction;
        String nameItem = "";
        Menu menu = new Menu();
        menu.printWelcomeMessage();
        User loggedUser = null;

        do {
            menu.printMenu();
            String inputFromUser = menu.readInputFromKeyboard();
            int optionNumber = menu.numberOptionFromInputString(inputFromUser);

            if(optionNumber == MenuOptions.LOG_IN.numberOption()){
                if(loggedUser == null){
                    List<String> credentials = menu.getInputCredentials();
                    loggedUser = menu.validateCredentials(credentials);
                }
            }else if(optionNumber == MenuOptions.CHECKOUT_BOOK.numberOption()
                    || optionNumber == MenuOptions.RETURN_BOOK.numberOption()){

                if(loggedUser != null){
                    nameItem = menu.getNameItemFromInput();
                }
            }else if (optionNumber == MenuOptions.CHECKOUT_MOVIE.numberOption()
                    || optionNumber == MenuOptions.RETURN_MOVIE.numberOption()){
                nameItem = menu.getNameItemFromInput();
            }else if(optionNumber == MenuOptions.LOG_OUT.numberOption()){
                loggedUser = null;
            }

            resultFromAction = menu.doActionFromOption(optionNumber, nameItem, loggedUser);
            System.out.println(resultFromAction);
        }while (!resultFromAction.equals(MenuOptions.QUIT.nameOption()));
    }
}