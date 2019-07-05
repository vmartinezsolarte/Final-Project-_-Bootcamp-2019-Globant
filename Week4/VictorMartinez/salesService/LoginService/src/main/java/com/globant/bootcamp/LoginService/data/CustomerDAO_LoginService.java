package com.globant.bootcamp.LoginService.data;

import com.globant.bootcamp.LoginService.domain.Customer;

public class CustomerDAO_LoginService {



    private String message;
    private String lastResult;
    private Customer customerAccount;

    public CustomerDAO_LoginService(){ }

    public CustomerDAO_LoginService(String message, String result, Customer  customerAccount) {
        super();
        this.message = (message == null) ? "No Message" : message;
        this.lastResult = (result == null) ? "No Result " : result;
        this.customerAccount = customerAccount;
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

    public Customer getUserAccount() {
        return customerAccount;
    }

    public void setUserAccount(Customer customer) {
        this.customerAccount = customer;
    }
}
