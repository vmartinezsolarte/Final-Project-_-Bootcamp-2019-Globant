package com.globant.bootcamp.LoginService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages ={
        "com.globant.bootcamp.LoginService.data",
        "com.globant.bootcamo.LoginService"})
public class LoginServiceApplication {


    public static void main(String[] args){
        SpringApplication.run(LoginServiceApplication.class, args);
    }
}

