package com.globant.bootcamp.LoginService.exceptions;

public class EmptyAccountException extends RuntimeException {
    private String message = "This user Account is Empty" ;
    public String getMsg(){ return message;}
    public void setMsg(String msg){ this.message = msg;}
}
