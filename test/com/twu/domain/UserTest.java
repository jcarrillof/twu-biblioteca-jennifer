package com.twu.domain;

import com.twu.domain.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    private User user = new User("001-0001", "user_pass1", "Jennifer Carrillo", "jcarrill@email.com", "0982832833");

    @Test
    public void shouldReturnUsernameWhenCreated() {
        String username = user.getUsername();
        assertEquals("001-0001", username);
    }

    @Test
    public void shouldReturnPasswordWhenCreated() {
        String password = user.getPassword();
        assertEquals("user_pass1", password);
    }

    @Test
    public void shouldReturnNameWhenCreated() {
        String name = user.getName();
        assertEquals("Jennifer Carrillo", name);
    }

    @Test
    public void shouldReturnEmailWhenCreated() {
        String email = user.getEmail();
        assertEquals("jcarrill@email.com", email);
    }

    @Test
    public void shouldReturnPhoneNumberWhenCreated() {
        String phoneNumber = user.getPhoneNumber();
        assertEquals("0982832833", phoneNumber);
    }

    @Test
    public void shouldReturnUserInformation() {
        String expected = "\nName: " + user.getName() + "\n"
                + "Email: " + user.getEmail() + "\n"
                + "Phone number: " + user.getPhoneNumber() + "\n";

        assertEquals(expected, user.userDetails());
    }

    @Test
    public void shouldReturnFalseWhenUserCreated() {
        assertFalse(user.isUserLogin());
    }

    @Test
    public void shouldReturnFalseWhenUserIsNotLogin() {
        user.setUserLogin(false);
        assertFalse(user.isUserLogin());
    }

    @Test
    public void shouldReturnTrueWhenUserLogin() {
        user.setUserLogin(true);
        assertTrue(user.isUserLogin());
    }
}
