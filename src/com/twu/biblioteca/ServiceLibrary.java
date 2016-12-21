package com.twu.biblioteca;

import com.twu.dominio.User;

public interface ServiceLibrary {
    String serviceFromLibraryGivenOption(String nameBook, User userWhoCheckOutItemWhenNeeded);
}
