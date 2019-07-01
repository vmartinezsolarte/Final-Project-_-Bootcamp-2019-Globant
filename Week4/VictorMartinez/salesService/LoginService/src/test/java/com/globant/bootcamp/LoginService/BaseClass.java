package com.globant.bootcamp.LoginService;

import com.globant.bootcamp.LoginService.business.Authenticator;
import com.globant.bootcamp.LoginService.configuration.ServicesImpl;
import com.globant.bootcamp.LoginService.controller.LoginServiceController;
import com.globant.bootcamp.LoginService.repository.CustomLoginServiceRepository;
import com.globant.bootcamp.LoginService.data.DataSource;
import com.globant.bootcamp.LoginService.data.AccountDAO_LoginService;
import com.globant.bootcamp.LoginService.data.AccountMultiplDAO_LoginService;
import com.globant.bootcamp.LoginService.domain.Account;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LoginServiceApplication.class)
public abstract class BaseClass {

    @Autowired
    private LoginServiceController loginServiceController;

    @MockBean
    private DataSource dataSource;

    @MockBean
    private ServicesImpl services;

    @MockBean
    private Authenticator authenticator;

    @MockBean
    private CustomLoginServiceRepository customLoginServiceRepository;
/*
     usersInfo.put("Andres", new Account("Andres", "1234", "an@un.edu.co"));
        usersInfo.put("Antonio",new Account("Antonio", "absd", "to@un.edu.co"));
        usersInfo.put("Mike", new Account("Mike","secret", "m@ls.edu.co"));
        usersInfo.put("Tony", new Account("Tony","Stark", "starks@tony.com"));
        usersInfo.put("Juan", new Account("Juan","060754", "Juanloco@hotmail.com"));
        usersInfo.put("Andrea", new Account("Andrea","I<3NY", "Andrealoca@gmail.com"));
        usersInfo.put("Natalia", new Account("Natalia","SailorMoon", "Sailor76@exu.com"));
        usersInfo.put("Luis", new Account("Luis", "Functional", "luchito4ever@yahoo.es"));
  */
    @Before
    public void setup() {

        RestAssuredMockMvc.standaloneSetup(loginServiceController);

        Mockito.when(dataSource.getPassWord("Andres")).thenReturn("1234");

        Mockito.when(services.correctSyntaxEmail(any(String.class))).thenReturn(true);

        Mockito.when(services.correctSyntaxPassword(any(String.class))).thenReturn(true);

        Mockito.when(authenticator.authenticateByEmail("Natalia", "SailorMoon")).thenReturn(true);

        Mockito.when(services.validRolRequest("admin","Andres","1234")).thenReturn(true);

        Mockito.when(authenticator.validateRequestByName("Andres","1234")).thenReturn(
                ResponseEntity.accepted()
                        .header("LogingService", "User Found ")
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(
                                new AccountDAO_LoginService(
                                        "User Found",
                                        "User found Succesfully",
                                        new Account(
                                                "Andres",
                                                "1234",
                                                "an@un.edu.co"
                                        )
                                )
                        )
        );

        Mockito.when(loginServiceController.getUserByNameSimple("Andres","1234"))
                .thenReturn(
                        ResponseEntity.accepted()
                        .header("LogingService", "User Found ")
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(
                                new AccountDAO_LoginService(
                                        "User Found",
                                        "User found Succesfully",
                                        new Account(
                                                "Andres",
                                                "1234",
                                                "an@un.edu.co"
                                        )
                                )
                        )
                );

        Mockito.when(this.loginServiceController.getUserByEmailLiteral("Sailor76@exu.com", "SailorMoon"))
                .thenReturn(
                        ResponseEntity.accepted()
                                .header("LogingService", "User Found ")
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(
                                        new AccountDAO_LoginService(
                                                "User Found",
                                                "User found Succesfully",
                                                new Account(
                                                        "Natalia",
                                                        "SailorMoon",
                                                        "Sailor76@exu.com"
                                                )
                                        )
                                )
                );

        Mockito.when(authenticator.processRequestGetAllUsers(any(String.class),any(String.class),any(String.class)))
                .thenReturn(
                        ResponseEntity.accepted()
                                .header("LogingService", "User Found ")
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(
                                        new AccountMultiplDAO_LoginService(
                                                "Users Found",
                                                "Users found Succesfully",
                                                new HashMap<String, Account>(){
                                                    {
                                                        put("Andres", new Account("Andres", "1234", "an@un.edu.co"));
                                                        put("Natalia", new Account("Natalia", "SailorMoon", "Sailor76@exu.com"));
                                                        //put("Luis", new Account("Luis", "Functional", "luchito4ever@yahoo.es"));
                                                    }
                                                }

                                        )
                                )
                );

        Mockito.when(this.loginServiceController.getAllUsers(any(String.class),any(String.class),any(String.class)))
                .thenReturn(
                        ResponseEntity.accepted()
                                .header("LogingService", "User Found ")
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(
                                        new AccountMultiplDAO_LoginService(
                                                "Users Found",
                                                "Users found Succesfully",
                                                new HashMap<String, Account>(){
                                                    {
                                                    put("Andres", new Account("Andres", "1234", "an@un.edu.co"));
                                                    put("Natalia", new Account("Natalia", "SailorMoon", "Sailor76@exu.com"));
                                                    //put("Luis", new Account("Luis", "Functional", "luchito4ever@yahoo.es"));
                                                    }
                                                }

                                        )
                                )
                );

        /*Mockito.when(this.services.processRequestGetAllUsers()).thenReturn(
                new HashMap<String, Account>(){
                    {
                        put("Andres", new Account("Andres", "1234", "an@un.edu.co"));
                        put("Natalia", new Account("Natalia", "SailorMoon", "Sailor76@exu.com"));
                        //put("Luis", new Account("Luis", "Functional", "luchito4ever@yahoo.es"));
                    }
                }
        );
        */
        Mockito.when(this.customLoginServiceRepository.getAllUsers()).thenReturn(
                new HashMap<String, Account>(){
                    {
                        put("Andres", new Account("Andres", "1234", "an@un.edu.co"));
                        put("Natalia", new Account("Natalia", "SailorMoon", "Sailor76@exu.com"));
                        //put("Luis", new Account("Luis", "Functional", "luchito4ever@yahoo.es"));
                    }
                }
        );



    }



}
