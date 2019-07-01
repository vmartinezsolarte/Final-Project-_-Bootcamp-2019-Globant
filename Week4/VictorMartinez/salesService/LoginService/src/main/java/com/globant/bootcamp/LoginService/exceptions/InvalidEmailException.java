package com.globant.bootcamp.LoginService.exceptions;

public class InvalidEmailException extends RuntimeException {

    private String message = "Invalid Email; Empty space not allowed nor special characters as / * - + $ #  ? ¿ ! ¡ and " ;
    public String getMsg(){ return message;}
    public void setMsg(String msg){ this.message = msg;}

}
