package com.globant.bootcamp.LoginServiceRoot.controller;

import com.globant.bootcamp.LoginServiceRoot.data.LoginServiceDAO;
import com.globant.bootcamp.LoginServiceRoot.data.LoginServiceMultipleDAO;
import com.globant.bootcamp.LoginServiceRoot.domain.Account;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.management.LockInfo;
import java.lang.reflect.Array;
import java.util.Arrays;

import static com.globant.bootcamp.LoginServiceRoot.util.auxFunctions.*;

//Test Fail; GET body is ignored.


@RestController
public class LoginServiceRootController {

    private RestTemplate restTemplate;

    public LoginServiceRootController(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }


    @RequestMapping(value = "/authenticate/{username}/{password}",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginServiceDAO getUserByNameSimple(
            @PathVariable("username") String username,
            @PathVariable("password") String password) {

        HttpEntity<LoginServiceDAO> request = createRequestBurnedUser();
        ResponseEntity<LoginServiceDAO> entity = restTemplate.exchange(
                "http://localhost:8151/authenticate/"+username+"/"+password,
                HttpMethod.GET, request,
                LoginServiceDAO.class);

        return entity.getBody();
    }

    @RequestMapping(value = "/authenticate/username/{username}/{password}",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginServiceDAO getUserByNameSimpleUsername(
            @PathVariable("username") String username,
            @PathVariable("password") String password) {

        HttpEntity<LoginServiceDAO> request = createRequestBurnedUser();
        ResponseEntity<LoginServiceDAO> entity = restTemplate.exchange(
                "http://localhost:8151/authenticate/username/"+username+"/"+password,
                HttpMethod.GET, request,
                LoginServiceDAO.class);

        return entity.getBody();
    }

    @RequestMapping(value = "/authenticate/user/{username}/{password}",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginServiceDAO getUserByNameSimpleUser(
            @PathVariable("username") String username,
            @PathVariable("password") String password) {

        HttpEntity<LoginServiceDAO> request = createRequestBurnedUser();
        ResponseEntity<LoginServiceDAO> entity = restTemplate.exchange(
                "http://localhost:8151/authenticate/user/"+username+"/"+password,
                HttpMethod.GET, request,
                LoginServiceDAO.class);

        return entity.getBody();
    }

    @RequestMapping(value = "/authenticate/email/{email}/{password}",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginServiceDAO getUserByEmailSimple(
            @PathVariable("email") String email,
            @PathVariable("password") String password) {

        HttpEntity<LoginServiceDAO> request = createRequestEmptyUser();
        ResponseEntity<LoginServiceDAO> entity = restTemplate.exchange(
                "http://localhost:8151/authenticate/email/"+email+"/"+password,
                HttpMethod.GET, request,
                LoginServiceDAO.class);

        return entity.getBody();
    }

    @RequestMapping(value = "/authenticate/allUsers",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginServiceMultipleDAO getAllUsers() {


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("rol", "admin");
        headers.set("name", "Andres");
        headers.set("password","1234");
        headers.set("email", "an@un.edu.co");
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<LoginServiceMultipleDAO> request = new HttpEntity<LoginServiceMultipleDAO>(null,headers);


        ResponseEntity<LoginServiceMultipleDAO> entity = restTemplate.exchange(
                "http://localhost:8151/authenticate/allUsers",
                HttpMethod.GET, request,
                LoginServiceMultipleDAO.class);

        return entity.getBody();
    }



}
