package com.globant.bootcamp.LoginService.loggers;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLogger {

    @Pointcut("execution(* *(..)) && within(com.globant.bootcamp.LoginService.controller..*)")
    public void executeController() { }

    @Before("execution(* com.globant.bootcamp.LoginService.controller.LoginServiceController.getUserByNameSimple(..))")
    public void loggIn(){
        System.out.println("Va entrando");
    }

    @After("execution(* com.globant.bootcamp.LoginService.controller.LoginServiceController.getUserByNameSimple(..))")
    public void loggInAfter(){
        System.out.println("salio ");
    }

    @Before("executeController()")
    public void loggInController(){
        System.out.println(" ");
        System.out.println(" Before : Pause created by the ASPECT that affects all methods in packages");
        System.out.println(" ");
    }

    @After("executeController()")
    public void loggOutController(){
        System.out.println(" ");
        System.out.println("After : Pause created by the ASPECT that affects all methods in packages");
        System.out.println(" ");
    }

}
