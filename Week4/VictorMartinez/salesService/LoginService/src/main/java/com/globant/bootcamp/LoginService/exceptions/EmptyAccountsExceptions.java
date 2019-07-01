package com.globant.bootcamp.LoginService.exceptions;

public class EmptyAccountsExceptions extends RuntimeException {
    private String message = "Not Accounts Registered - Empty List Account Exception" ;
    public String getMsg(){ return message;}
    public void setMsg(String msg){ this.message = msg;}
}
