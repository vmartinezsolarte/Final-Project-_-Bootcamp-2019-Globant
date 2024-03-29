package com.globant.bootcamp.LoginServiceRoot.data;

import com.globant.bootcamp.LoginServiceRoot.domain.Account;

public class LoginServiceDAO {


    private String message;
    private String lastResult;
    private Account userAccount;

    public LoginServiceDAO(){ }

    public LoginServiceDAO(String message, String result, Account userAccount) {
        super();
        this.message = (message == null) ? "No Message" : message;
        this.lastResult = (result == null) ? "No Result " : result;
        this.userAccount = (userAccount == null) ? null : userAccount;
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

    public Account getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Account userAccount) {
        this.userAccount = userAccount;
    }
}