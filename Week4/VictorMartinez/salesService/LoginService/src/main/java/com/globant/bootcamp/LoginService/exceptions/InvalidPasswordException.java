package com.globant.bootcamp.LoginService.exceptions;

public class InvalidPasswordException extends RuntimeException {

    private String message = "Invalid Password; empty space not allowed nor special characters as / * - + $ # . ? ¿ ! ¡ and lenght got to be greater than 3 values" ;
    public String getMsg(){ return message;}
    public void setMsg(String msg){ this.message = msg;}

}
