package com.globant.bootcamp.LoginService.exceptions;

public class InvalidnewuserEmailException extends  RuntimeException {
    private String message = "Incorrect Email from the User" ;
    public String getMsg(){ return message;}
    public void setMsg(String msg){ this.message = msg;}
}
