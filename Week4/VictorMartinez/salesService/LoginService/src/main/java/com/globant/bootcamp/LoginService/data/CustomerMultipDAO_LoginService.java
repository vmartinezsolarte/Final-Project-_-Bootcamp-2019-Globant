package com.globant.bootcamp.LoginService.data;

import com.globant.bootcamp.LoginService.domain.Account;
import com.globant.bootcamp.LoginService.domain.Customer;

import java.util.HashMap;

public class CustomerMultipDAO_LoginService {

    private String message;
    private String lastResult;
    private HashMap<String, Customer> Customers;

    public CustomerMultipDAO_LoginService(){ }

    public CustomerMultipDAO_LoginService(String message, String result, HashMap Customers) {
        super();
        this.message = (message == null) ? "No Message" : message;
        this.lastResult = (result == null) ? "No Result " : result;
        this.Customers = Customers;
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
        return Customers;
    }

    public void setUserAccount(HashMap<String, Customer> Customers) {this.Customers = Customers;}

}
