package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    private Login login = new Login();

    @Test
    public void shouldReturnUserWhenCredentialsAreValid() {
        String username = login.listUsers.get(0).getUsername();
        String password = login.listUsers.get(0).getPassword();
        assertEquals(login.listUsers.get(0), login.validCredentials(username, password));
    }

    @Test
    public void shouldReturnNullWhenCredentialsAreNotValid() {
        String username = "001-0001";
        String password = "password";
        assertEquals(null, login.validCredentials(username, password));
    }

    @Test
    public void shouldReturnUsernameWhenIsLoggedIn() {
        login.listUsers.get(0).setUserLogin(true);
        String expected = login.listUsers.get(0).userDetails();
        assertEquals(expected, login.getUserDetailsIsLoggedIn(login.listUsers.get(0)));
    }

    @Test
    public void shouldReturnNullWhenUserIsNotLoggedIn() {
        assertEquals("You must be logged in", login.getUserDetailsIsLoggedIn(null));
    }

    @Test
    public void shouldReturnValidCredentialsMessageWhenLoginUser() {
        assertEquals("You are now logged in", login.loginUser(login.listUsers.get(0)));
    }

    @Test
    public void shouldReturnNoValidCredentialsMessageWhenLoginUserIsNull() {
        assertEquals("Credentials are not valid", login.loginUser(null));
    }

    @Test
    public void shouldReturnValidCredentialsMessageWhenLogoutUser() {
        assertEquals("You logged out", login.logoutUser(login.listUsers.get(0)));
    }

    @Test
    public void shouldReturnNoValidCredentialsMessageWhenNoSessionActive() {
        assertEquals("There is no active session", login.logoutUser(null));
    }

    @Test
    public void shouldReturnFalseSessionActiveWhenUserIsNull() {
        assertFalse(login.isActiveSession(null));
    }

    @Test
    public void shouldReturnFalseSessionActiveWhenUserIsNotLoggedIn() {
        login.listUsers.get(0).setUserLogin(false);
        assertFalse(login.isActiveSession(login.listUsers.get(0)));
    }

    @Test
    public void shouldReturnTrueSessionActiveWhenUserIsLoggedIn() {
        login.listUsers.get(0).setUserLogin(true);
        assertTrue(login.isActiveSession(login.listUsers.get(0)));
    }
}
