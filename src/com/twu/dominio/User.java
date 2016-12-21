package com.twu.dominio;

public class User {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private boolean userLogin;

    public User(String username, String password, String name, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userLogin = false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String userDetails() {
        return "Name: " + getName() + "\n"
                + "Email: " + getEmail() + "\n"
                + "Phone number: " + getPhoneNumber() + "\n";
    }

    public void setUserLogin(boolean userLogin) {
        this.userLogin = userLogin;
    }

    public boolean isUserLogin() {
        return userLogin;
    }
}