package com.globant.bootcamp.LoginService.exceptions;

public class InvalidUsernameException extends  RuntimeException{
    private String message = "Invalid Username; empty space not allowed nor special characters as / * - + $ # . ? ¿ ! ¡ ";
    public String getMsg(){ return message;}
    public void setMsg(String msg){ this.message = msg;}
}
