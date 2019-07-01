package com.globant.bootcamp.LoginService.exceptions;

public class WrongPasswordException extends RuntimeException{
    private String message = "Wrong PassWord. Exiting from App at this moment";
    public String getMsg(){ return message;}
    public void setMsg(String msg){ this.message = msg;}
}
