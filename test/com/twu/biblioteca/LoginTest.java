package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    private Login login = new Login();

    @Test
    public void shouldReturnTrueWhenCredentialsAreValid() {
        String username = login.listUsers.get(0).getUsername();
        String password = login.listUsers.get(0).getPassword();
        assertEquals(0, login.validCredentials(username, password));
    }

    @Test
    public void shouldReturnFalseWhenCredentialsAreNotValid() {
        String username = "001-0001";
        String password = "password";
        assertEquals(-1, login.validCredentials(username, password));
    }

    @Test
    public void shouldReturnUsernameWhenIsLoggedIn() {
        login.listUsers.get(0).setUserLogin(true);
        String expected = login.listUsers.get(0).userDetails();
        assertEquals(expected, login.getUserDetailsIsLoggedIn(0));
    }

    @Test
    public void shouldReturnNullWhenUserIsNotLoggedIn() {
        assertEquals("You must be logged in or your credentials are not valid", login.getUserDetailsIsLoggedIn(-1));
    }
}