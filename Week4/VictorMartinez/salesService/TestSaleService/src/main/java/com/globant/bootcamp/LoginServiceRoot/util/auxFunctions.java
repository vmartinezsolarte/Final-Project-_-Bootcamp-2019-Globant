package com.globant.bootcamp.LoginServiceRoot.util;

import com.globant.bootcamp.LoginServiceRoot.data.LoginServiceDAO;
import com.globant.bootcamp.LoginServiceRoot.domain.Account;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


import java.util.Arrays;

public class auxFunctions {

    public static HttpHeaders getDaoSimpleHeader() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

    public static LoginServiceDAO burnedUserAndres() {
        LoginServiceDAO inputDAO = new LoginServiceDAO(
                "Search user",
                "DAO search",
                new Account("Andres", "1234", "an@un.edu.co"));
        return inputDAO;
    }

    public static HttpHeaders createBurnedHeader(){
        HttpHeaders headers = getDaoSimpleHeader();
        headers.set("rol", "admin");
        headers.set("name", "Andres");
        headers.set("password", "1234");
        return headers;
    }

    public static LoginServiceDAO createUser(
            String message,
            String result,
            String username,
            String password,
            String email) {

        LoginServiceDAO inputDAO = new LoginServiceDAO(
                message,
                result,
                new Account(
                        username,
                        password,
                        email
                ));
        return inputDAO;
    }

    public static HttpEntity<LoginServiceDAO> createRequestBurnedUser() {

        HttpEntity<LoginServiceDAO> newRequest = new HttpEntity<LoginServiceDAO>(
                burnedUserAndres(),
                getDaoSimpleHeader());

        return newRequest;
    }


    public static HttpEntity<LoginServiceDAO> createRequestEmptyUser() {

        HttpEntity<LoginServiceDAO> newRequest = new HttpEntity<LoginServiceDAO>(
                null,
                getDaoSimpleHeader());

        return newRequest;
    }

    public static HttpEntity<LoginServiceDAO> createRequestBurnedUserHeader(){
        HttpEntity<LoginServiceDAO> newRequest = new HttpEntity<LoginServiceDAO>(
                null,
                createBurnedHeader()
        );
        return newRequest;
    }

    public static HttpEntity<LoginServiceDAO> createRequestUser(
            String message,
            String result,
            String username,
            String password,
            String email) {

        HttpEntity<LoginServiceDAO> newHttpRequest = new HttpEntity<LoginServiceDAO>(
                createUser(message,result,username,password,email),
                getDaoSimpleHeader());

        return newHttpRequest;
    }




}