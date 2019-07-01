package com.globant.bootcamp.LoginService.exceptions;

public class InvalidnewuserPasswordException extends RuntimeException {
    private String message = "PassWord from the New User is Invalid" ;
    public String getMsg(){ return message;}
    public void setMsg(String msg){ this.message = msg;}
}
