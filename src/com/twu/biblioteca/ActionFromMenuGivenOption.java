package com.twu.biblioteca;

import com.twu.dominio.User;

public interface ActionFromMenuGivenOption {
    String executeAction(String nameBook, User userWhoCheckOutItemWhenNeeded);
}
