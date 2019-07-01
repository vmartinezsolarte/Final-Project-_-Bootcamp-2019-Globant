package com.globant.bootcamp.LoginServiceRoot.data;

public class TwoStringsLoginServiceDAO {



    private String message;
    private String lastResult;
    private String username;
    private String newProperty;

    public TwoStringsLoginServiceDAO(){ }

    public TwoStringsLoginServiceDAO(
            final String message,
            final String result,
            final String username,
            final String newProperty)
    {
        super();
        this.message = (message == null) ? "No Message" : message;
        this.lastResult = (result == null) ? "No Result " : result;
        this.username = (username==null)? "No username " : username;
        this.newProperty = (newProperty ==null) ? "No new Property" : newProperty;
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

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getNewProperty() { return newProperty; }

    public void setNewProperty(String newProperty) { this.newProperty = newProperty; }
}
