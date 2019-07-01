package com.globant.bootcamp.LoginServiceRoot.domain;

public class Account {

    private String username;
    private String password;
    private String email;

    public Account() { }

    public Account(final String username, final String password, final String email) {
        super();
        this.username = username;
        this.password = password;
        this.email    = email;
    }

    public Account(final String username, final String password) {
        super();
        this.username = username;
        this.password = password;
        this.email    = "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
