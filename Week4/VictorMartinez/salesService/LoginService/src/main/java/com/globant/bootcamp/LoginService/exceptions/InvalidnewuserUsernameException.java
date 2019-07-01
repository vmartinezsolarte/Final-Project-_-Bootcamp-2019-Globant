package com.globant.bootcamp.LoginService.exceptions;

public class InvalidnewuserUsernameException extends  RuntimeException {
    private String message = "The username from the new User is invalid" ;
    public String getMsg(){ return message;}
    public void setMsg(String msg){ this.message = msg;}
}
