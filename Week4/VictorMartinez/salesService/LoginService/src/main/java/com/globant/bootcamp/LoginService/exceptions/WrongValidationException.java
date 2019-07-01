package com.globant.bootcamp.LoginService.exceptions;

public class WrongValidationException extends  RuntimeException {
    private String message = "Invalid User permission or Password Exception";
    public String getMsg(){ return message;}
    public void setMsg(String msg){ this.message = msg;}
}
