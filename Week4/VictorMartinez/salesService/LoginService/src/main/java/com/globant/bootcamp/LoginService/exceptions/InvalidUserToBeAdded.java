package com.globant.bootcamp.LoginService.exceptions;

public class InvalidUserToBeAdded extends  RuntimeException {
    private String message = " Exception due to an invalid AddUser Request; The user already exist? ";
    public String getMsg(){ return message;}
    public void setMsg(String msg){ this.message = msg;}
}
