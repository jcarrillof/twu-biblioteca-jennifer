package com.twu.biblioteca;

import java.util.List;

/**
 * Created by jcarrillo on 2/12/16.
 */
public class Menu {

    public String selectedOption(String inputIntFromScanner) {

        switch (inputIntFromScanner){
            case "1":
                return String.valueOf(inputIntFromScanner);
            case "0":
                return "Quit";
            default:
                return "Select a valid option!";
        }
    }
}
