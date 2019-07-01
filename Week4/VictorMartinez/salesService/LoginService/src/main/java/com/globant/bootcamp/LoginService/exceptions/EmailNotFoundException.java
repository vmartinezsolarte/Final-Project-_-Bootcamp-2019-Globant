package com.globant.bootcamp.LoginService.exceptions;

public class EmailNotFoundException extends RuntimeException {
    private String message = "Email account doesnt exist; Check your email once again please" ;
    public String getMsg(){ return message;}
    public void setMsg(String msg){ this.message = msg;}
}
