package com.twu.biblioteca;

import com.twu.resources.Messages;
import com.twu.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {

    public List<User> listUsers = new ArrayList<>();

    Login(){
        User userOne = new User("001-0001", "user_pass_0001", "Jennifer Carrillo", "jcarrillo@email.com", "0987482832");
        listUsers.add(userOne);
        User userTwo = new User("001-0002", "user_pass_0002", "Andrea Ortega", "aortega@email.com", "0995242965");
        listUsers.add(userTwo);
    }

    public List<String> getInputCredentials(){
        List<String> credentials = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        credentials.add(username);
        credentials.add(password);
        System.out.println();
        return credentials;
    }

    public User validCredentials(String username, String password) {
        for (User user:listUsers) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public String getUserDetailsIsLoggedIn(User userLoggedIn) {
        try {
            return userLoggedIn.userDetails();
        }catch (Exception exception){
            return Messages.LOGIN_REQUIRED.toString();
        }
    }

    public String loginUser(User userWhoLogIn) {
        try {
            if(userWhoLogIn.isUserLogin()){
                return Messages.SESSION_ACTIVE.toString();
            }
            userWhoLogIn.setUserLogin(true);
            return Messages.CREDENTIALS_VALID.toString();
        }catch (Exception exception){
            return Messages.CREDENTIALS_NOT_VALID.toString();
        }
    }

    public String logoutUser(User userWhoLogIn) {
        try {
            userWhoLogIn.setUserLogin(false);
            return Messages.USER_LOGOUT.toString();
        }catch (Exception exception){
            return Messages.SESSION_INACTIVE.toString();
        }
    }

    public boolean isActiveSession(User userWhoCheckOutItemWhenNeeded) {
        try {
            return userWhoCheckOutItemWhenNeeded.isUserLogin();
        }catch (Exception exception){
            return false;
        }
    }
}
