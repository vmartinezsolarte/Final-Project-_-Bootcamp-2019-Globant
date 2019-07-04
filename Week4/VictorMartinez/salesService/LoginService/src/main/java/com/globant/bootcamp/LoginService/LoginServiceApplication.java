package com.globant.bootcamp.LoginService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




/*scanBasePackages ={
        "com.globant.bootcamp.LoginService.data",
        "com.globant.bootcamo.LoginService.*"})
*/
/*

@EntityScan(basePackages = {"com.globant.bootcamp.LoginService.domain", "com.globant.bootcamp.LoginService.data.DataSource"})
*/

//"com.globant.bootcamp.LoginService.data.DataSource",,


@ComponentScan(basePackages = {
        "com.globant.bootcamp.LoginService.data.DataSource",
        "com.globant.bootcamp.LoginService.controller.LoginServiceController"})
@SpringBootApplication
//@EnableJpaRepositories("com.globant.bootcamp.LoginService.repository")
public class LoginServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(LoginServiceApplication.class, args);
    }
}

