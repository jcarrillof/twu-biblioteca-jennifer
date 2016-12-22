package com.twu.biblioteca;

import com.twu.domain.User;

public interface ActionFromMenuGivenOption {
    String executeAction(String nameBook, User userWhoCheckOutItemWhenNeeded);
}
