package com.globant.bootcamp.LoginService.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class Account {

    @ApiModelProperty(notes = "username of customer",name="usernameUserAccount",required=true,value="test AccountUsername")
    @NotNull
    private String username;

    @ApiModelProperty(notes = "password of customer",name="passwordUserAccount",required=true,value="test AccountPassword")
    @NotNull
    private String password;

    @ApiModelProperty(notes = "email of customer",name="emailUserAccount",required=false,value="test AccountEmail")
    @NotNull
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
