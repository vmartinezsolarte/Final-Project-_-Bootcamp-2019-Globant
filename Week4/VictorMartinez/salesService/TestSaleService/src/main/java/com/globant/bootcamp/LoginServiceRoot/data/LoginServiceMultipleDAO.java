package com.globant.bootcamp.LoginServiceRoot.data;

import com.globant.bootcamp.LoginServiceRoot.domain.Account;

import java.util.HashMap;

public class LoginServiceMultipleDAO {

    private String message;
    private String lastResult;
    private HashMap<String, Account> accountsList;

    public LoginServiceMultipleDAO(){ }

    public LoginServiceMultipleDAO(String message, String result, HashMap accountsList) {
        super();
        this.message = (message == null) ? "No Message" : message;
        this.lastResult = (result == null) ? "No Result " : result;
        this.accountsList = (accountsList == null) ? null : accountsList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLastResult() {
        return lastResult;
    }

    public void setLastResult(String lastResult) {
        this.lastResult = lastResult;
    }

    public HashMap getUserAccount() {
        return accountsList;
    }

    public void setUserAccount(HashMap<String, Account> accountsList) {
        this.accountsList = accountsList;
    }

}
