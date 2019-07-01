package com.globant.bootcamp.LoginService.exceptions;

public class UserNotFoundException extends RuntimeException {
    private String message = "User not Found. Check the syntax for the username";
    public String getMsg(){ return message;}
    public void setMsg(String msg){ this.message = msg;}
}
