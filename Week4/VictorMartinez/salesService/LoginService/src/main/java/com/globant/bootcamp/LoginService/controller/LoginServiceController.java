package com.globant.bootcamp.LoginService.controller;

import com.globant.bootcamp.LoginService.business.Authenticator;
import com.globant.bootcamp.LoginService.business.AuthenticatorImpl;
import com.globant.bootcamp.LoginService.data.AccountDAO_LoginService;
import com.globant.bootcamp.LoginService.data.AccountMultiplDAO_LoginService;
import com.globant.bootcamp.LoginService.data.CustomerDAO_LoginService;
import com.globant.bootcamp.LoginService.data.TwoStringsDAO_LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

@RestController
public class LoginServiceController {

    @Autowired
    Authenticator authenticator;

    @GetMapping(value="/authenticate/{username}/{password}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CustomerDAO_LoginService> getUserByNameSimple(@PathVariable String username, @PathVariable String password) {
        System.out.println("Hey");
        return null;
        //return this.authenticator.processRequestByName(username, password);
    }

    //checked -- died Get Request can't carry body --Test
    @GetMapping(value="/authenticate",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDAO_LoginService> getUserByNameSimpleDAO(@RequestBody AccountDAO_LoginService inputDAO) {
        return this.authenticator.processRequestByName(inputDAO.getUserAccount().getUsername(), inputDAO.getUserAccount().getPassword());
    }

    //checked -- Passed --Test
    @GetMapping(value="/authenticate/username/{username}/{password}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDAO_LoginService> getUserByNameNested(@PathVariable String username, @PathVariable String password) {
            return this.authenticator.processRequestByName(username, password);
    }

    //checked -- died Get Request can't carry body --Test
    @GetMapping(value="/authenticate/username",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDAO_LoginService> getUserByNameDAO(@RequestBody AccountDAO_LoginService inputDAO) {
        return this.authenticator.processRequestByName(inputDAO.getUserAccount().getUsername(), inputDAO.getUserAccount().getPassword());
    }

    //checked -- Passed  --Test
    @GetMapping(value="/authenticate/user/{username}/{password}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDAO_LoginService> getUserInfo(@PathVariable String username, @PathVariable String password) {
        return this.authenticator.processRequestByName(username, password);
    }

    //checked -- died Get Request can't carry body --Test
    @GetMapping(value="/authenticate/email",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> getUserByEmail(@RequestBody AccountDAO_LoginService inputDAO) {
        return this.authenticator.processRequestByEmail(inputDAO.getUserAccount().getEmail(), inputDAO.getUserAccount().getPassword());
    }

    //checked -- Passed  --Test
    @GetMapping(value="/authenticate/email/{userEmail}/{password}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> getUserByEmailLiteral(@PathVariable String userEmail, @PathVariable String password) {
        return this.authenticator.processRequestByEmail(userEmail, password);
    }

    @GetMapping(value="/authenticate/allUsers",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountMultiplDAO_LoginService> getAllUsers(
            @RequestHeader(name = "rol", required = false) String rol,
            @RequestHeader(name = "name", required = false) String name,
            @RequestHeader(name = "password", required = false) String password) {
        return this.authenticator.processRequestGetAllUsers(rol, name, password);
    }

    @PostMapping(value="/authenticate",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> addUser(
            @RequestHeader(name = "rol", required = true) String rol,
            @RequestHeader(name = "name", required = true) String name,
            @RequestHeader(name = "password", required = true) String password,
            @RequestBody AccountDAO_LoginService inputDAO) {
        return this.authenticator.processRequestAddUserByName(rol, name, password, inputDAO.getUserAccount());
    }

    @PutMapping(value="/authenticate/{username}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> updateUserByName(
            @PathVariable("username") String username,
            @RequestHeader(name = "rol", required = true) String rol,
            @RequestHeader(name = "name", required = true) String rolname,
            @RequestHeader(name = "password", required = true) String rolpassword,
            @RequestBody AccountDAO_LoginService inputDAO) {
        return this.authenticator.processRequestupdateUserByName(rol, rolname, rolpassword, username, inputDAO.getUserAccount());
    }

    @PutMapping(value="/authenticate",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> updateUser(
            @RequestHeader(name = "rol", required = true) String rol,
            @RequestHeader(name = "name", required = true) String rolname,
            @RequestHeader(name = "password", required = true) String rolpassword,
            @RequestBody AccountDAO_LoginService inputDAO) {
        return this.authenticator.processRequestupdateUserByName(rol, rolname, rolpassword, inputDAO.getUserAccount().getUsername(), inputDAO.getUserAccount());
    }

    @DeleteMapping(value="/authenticate/{deleteUsername}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> deleteUser(
            @PathVariable("deleteUsername") String deleteUsername,
            @RequestHeader(name = "rol", required = true) String rol,
            @RequestHeader(name = "name", required = true) String rolname,
            @RequestHeader(name = "password", required = true) String rolpassword) {
        return this.authenticator.processRequestDeleteUserByName(rol, rolname, rolpassword, deleteUsername);
    }

    @DeleteMapping(value="/authenticate/username/{deleteUsername}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> deleteUserByName(
            @PathVariable("deleteUsername") String deleteUsername,
            @RequestHeader(name = "rol", required = true) String rol,
            @RequestHeader(name = "name", required = true) String rolname,
            @RequestHeader(name = "password", required = true) String rolpassword) {
        return this.authenticator.processRequestDeleteUserByName(rol, rolname, rolpassword, deleteUsername);
    }

    @DeleteMapping(value="/authenticate/email/{deleteUserEmail}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> deleteUserByEmail(
            @PathVariable("deleteUserEmail") String deleteUserEmail,
            @RequestHeader(name = "rol", required = true) String rol,
            @RequestHeader(name = "name", required = true) String rolname,
            @RequestHeader(name = "password", required = true) String rolpassword) {
        return this.authenticator.processRequestDeleteUserByEmail(rol, rolname, rolpassword, deleteUserEmail);
    }

    @DeleteMapping(value="/authenticate",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> deleteUserSimple(
            @RequestHeader(name = "rol", required = true) String rol,
            @RequestHeader(name = "name", required = true) String rolname,
            @RequestHeader(name = "password", required = true) String rolpassword,
            @RequestBody AccountDAO_LoginService inputDAO
    ) {
        return this.authenticator.processRequestDeleteUserByName(rol, rolname, rolpassword, inputDAO.getUserAccount().getUsername());
    }

    @DeleteMapping(value="/authenticate/username",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> deleteUserNestedName(
             @RequestHeader(name = "rol", required = true) String rol,
            @RequestHeader(name = "name", required = true) String rolname,
            @RequestHeader(name = "password", required = true) String rolpassword,
            @RequestBody AccountDAO_LoginService inputDAO
    ) {
        return this.authenticator.processRequestDeleteUserByName(rol, rolname, rolpassword, inputDAO.getUserAccount().getUsername());
    }


    @DeleteMapping(value="/authenticate/email",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> deleteUserNestedEmail(
            @RequestHeader(name = "rol", required = true) String rol,
            @RequestHeader(name = "name", required = true) String rolname,
            @RequestHeader(name = "password", required = true) String rolpassword,
            @RequestBody AccountDAO_LoginService inputDAO
    ) {
        return this.authenticator.processRequestDeleteUserByEmail(rol, rolname, rolpassword, inputDAO.getUserAccount().getEmail());
    }

    @PatchMapping(value="/authenticate/username/{oldUsername}/{newUsername}",
            consumes =  MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> updateUsername(
            @RequestHeader(name = "rol", required = true) String rol,
            @RequestHeader(name = "name", required = true) String rolname,
            @RequestHeader(name = "password", required = true) String rolpassword,
            @PathVariable("oldUsername") String oldUsername,
            @PathVariable("newUsername") String newUsername
    ){
        return this.authenticator.processRequestUpdateName(rol, rolname, rolpassword, oldUsername, newUsername);
    }

    @PatchMapping(value="/authenticate/username",
            consumes =  MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> updateUsername(
            @RequestHeader(name = "rol", required = true) String rol,
            @RequestHeader(name = "name", required = true) String rolname,
            @RequestHeader(name = "password", required = true) String rolpassword,
            @RequestBody TwoStringsDAO_LoginService inputDAO
            ){

        return this.authenticator.processRequestUpdateName(rol, rolname, rolpassword, inputDAO.getUsername(), inputDAO.getNewProperty());
    }

    @PatchMapping(value="/authenticate/email/{username}/{newEmail}",
            consumes =  MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> updateUserEmail(
            @RequestHeader(name = "rol", required = true) String rol,
            @RequestHeader(name = "name", required = true) String rolname,
            @RequestHeader(name = "password", required = true) String rolpassword,
            @PathVariable("username") String username,
            @PathVariable("newEmail") String newUserEmail
    ){
        return this.authenticator.processRequestUpdateNewEmail(rol, rolname, rolpassword, username, newUserEmail);
    }

    @PatchMapping(value="/authenticate/email",
            consumes =  MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> updateUserEmail(
            @RequestHeader(name = "rol", required = true) String rol,
            @RequestHeader(name = "name", required = true) String rolname,
            @RequestHeader(name = "password", required = true) String rolpassword,
            @RequestBody TwoStringsDAO_LoginService inputDAO
    ){
        return this.authenticator.processRequestUpdateNewEmail(rol, rolname, rolpassword, inputDAO.getUsername(), inputDAO.getNewProperty());
    }


    @PatchMapping(value="/authenticate/password/{username}/{newPassword}",
            consumes =  MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> updateUserPasswordLiteral(
            @RequestHeader(name = "rol", required = true) String rol,
            @RequestHeader(name = "name", required = true) String rolname,
            @RequestHeader(name = "password", required = true) String rolpassword,
            @PathVariable("username") String username,
            @PathVariable("newPassword") String newPassword
    ){
        return this.authenticator.processRequestUpdateNewPassword(rol, rolname, rolpassword, username, newPassword);
    }


    @PatchMapping(value="/authenticate/password",
            consumes =  MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> updateUserPassword(
            @RequestHeader(name = "rol", required = true) String rol,
            @RequestHeader(name = "name", required = true) String rolname,
            @RequestHeader(name = "password", required = true) String rolpassword,
            @RequestBody TwoStringsDAO_LoginService inputDAO
    ){

        return this.authenticator.processRequestUpdateName(rol, rolname, rolpassword, inputDAO.getUsername(), inputDAO.getNewProperty());
    }
















}
