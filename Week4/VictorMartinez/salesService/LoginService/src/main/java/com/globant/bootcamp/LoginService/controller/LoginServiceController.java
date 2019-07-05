package com.globant.bootcamp.LoginService.controller;

import com.globant.bootcamp.LoginService.business.Authenticator;
import com.globant.bootcamp.LoginService.data.AccountDAO_LoginService;
import com.globant.bootcamp.LoginService.data.AccountMultiplDAO_LoginService;
import com.globant.bootcamp.LoginService.data.CustomerDAO_LoginService;
import com.globant.bootcamp.LoginService.data.TwoStringsDAO_LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
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

@Api(value = "Swagger2LoginServiceController")
@RestController
public class LoginServiceController {




    @Autowired
    Authenticator authenticator;


    @ApiOperation(
            value = "GET request, passing username-password as arguments, for 'getting' Customer Data stored in MongoDB", 
            response = ResponseEntity.class,
            tags = "GETUserByUsernamePasswordSimple")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!!!"),
            @ApiResponse(code = 404, message = "Not found!!!") })
    @GetMapping(value="/authenticate/{username}/{password}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CustomerDAO_LoginService> getUserByNameSimple(@PathVariable String username, @PathVariable String password) {
        System.out.println("Hey");
        return this.authenticator.processRequestByName(username, password);
    }


    @ApiOperation(
            value = "GET request, passing username n password stored in body of http request, for 'getting' Customer Data stored in MongoDB",
            response = ResponseEntity.class,
            tags = "GETUserByUsernamePasswordDAO")
    @GetMapping(value="/authenticate",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDAO_LoginService> getUserByNameSimpleDAO(@RequestBody AccountDAO_LoginService inputDAO) {
        return this.authenticator.processRequestByName(inputDAO.getUserAccount().getUsername(), inputDAO.getUserAccount().getPassword());
    }

    
    @ApiOperation(
            value = "GET request,passing username n password nested in username domain, for 'getting' Customer Data stored in MongoDB",
            response = ResponseEntity.class,
            tags = "GETUserByUsernamePasswordNestedUsernameSimple")
    @GetMapping(value="/authenticate/username/{username}/{password}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDAO_LoginService> getUserByNameNested(@PathVariable String username, @PathVariable String password) {
            return this.authenticator.processRequestByName(username, password);
    }

    
    @ApiOperation(
            value = "GET request into username domain, passing username-password stored in body of http request, for 'getting' Customer Data stored in MongoDB",
            response = ResponseEntity.class,
            tags = "GETUserByUsernamePasswordNestedUsernameDAO")
    @GetMapping(value="/authenticate/username",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDAO_LoginService> getUserByNameDAO(@RequestBody AccountDAO_LoginService inputDAO) {
        return this.authenticator.processRequestByName(inputDAO.getUserAccount().getUsername(), inputDAO.getUserAccount().getPassword());
    }

    @ApiOperation(
            value = "GET request, passing username n password nested domain user, for 'getting' Customer Data stored in MongoDB",
            response = ResponseEntity.class,
            tags = "GETUserByUsernamePasswordNestedUserSimple")
    @GetMapping(value="/authenticate/user/{username}/{password}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDAO_LoginService> getUserInfo(@PathVariable String username, @PathVariable String password) {
        return this.authenticator.processRequestByName(username, password);
    }

    @ApiOperation(
            value = "GET request, passing email n password in body of http request, for 'getting' Customer Data stored in MongoDB",
            response = ResponseEntity.class,
            tags = "GETUserByEmailPasswordSimple")
    @GetMapping(value="/authenticate/email",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> getUserByEmail(@RequestBody AccountDAO_LoginService inputDAO) {
        return this.authenticator.processRequestByEmail(inputDAO.getUserAccount().getEmail(), inputDAO.getUserAccount().getPassword());
    }


    @ApiOperation(
            value = "GET request, passing email n password as arguments, for 'getting' Customer Data stored in MongoDB",
            response = ResponseEntity.class,
            tags = "GETUserByEmailPasswordDAO")
    @GetMapping(value="/authenticate/email/{userEmail}/{password}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDAO_LoginService> getUserByEmailLiteral(@PathVariable String userEmail, @PathVariable String password) {
        return this.authenticator.processRequestByEmail(userEmail, password);
    }


    @ApiOperation(
            value = "GET request, passing Admin Info, for 'getting' all Customers Data stored in MongoDB",
            response = ResponseEntity.class,
            tags = "GETUsersWithAdminValidation")
    @GetMapping(value="/authenticate/allUsers",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountMultiplDAO_LoginService> getAllUsers(
            @RequestHeader(name = "rol", required = false) String rol,
            @RequestHeader(name = "name", required = false) String name,
            @RequestHeader(name = "password", required = false) String password) {
        return this.authenticator.processRequestGetAllUsers(rol, name, password);
    }


    @ApiOperation(
            value = "POST request, validating Admin Info, for 'posting' a new Customer stored in MongoDB",
            response = ResponseEntity.class,
            tags = "POSTAddUsersWithAdminValidation")
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


    @ApiOperation(
            value = "PUT request, validating Admin Info, for 'putting' a Customer Info stored in MongoDB",
            response = ResponseEntity.class,
            tags = "PUTupdateUsersByNameInfo")
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


    @ApiOperation(
            value = "PUT request, validating Admin Info, for 'putting' a Customer Info in MongoDB",
            response = ResponseEntity.class,
            tags = "PUTupdateUserInfo")
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


    @ApiOperation(
            value = "DELETE request, passing Admin Info, for 'deleting' a Customer by username stored in MongoDB",
            response = ResponseEntity.class,
            tags = "DELETECustomerByUsername")
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


    @ApiOperation(
            value = "DELETE request, passing Admin Info, for 'deleting' a Customer username domain stored in MongoDB",
            response = ResponseEntity.class,
            tags = "DELETECustomerByUsernameDomain")
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



    @ApiOperation(
            value = "DELETE request, passing Admin Info, for 'deleting' a Customer stored in MongoDB by email ",
            response = ResponseEntity.class,
            tags = "DELETECustomerByEmail")
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



    @ApiOperation(
            value = "DELETE request, passing Admin Info, for 'deleting' a Customer stored in MongoDB with info in HTTP request",
            tags = "DELETECustomerByDAO")
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



    @ApiOperation(
            value = "DELETE request, passing Admin Info, for 'deleting' a Customer stored in MongoDB with info in HTTP request",
            response = ResponseEntity.class,
            tags = "DELETECustomerByDAONestedUsername")
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



    @ApiOperation(
            value = "DELETE request, passing Admin Info, for 'deleting' a Customer stored in MongoDB with info in HTTP request ",
            response = ResponseEntity.class,
            tags = "DELETECustomerByDAONestedEmail")
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



    @ApiOperation(
            value = "PATCH request, passing Admin Info, for 'patching' a Customer name stored in MongoDB through arguments ",
            response = ResponseEntity.class,
            tags = "PATCHCustomerUpdateUsernameArguments")
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



    @ApiOperation(
            value = "PATCH request, passing Admin Info, for 'patching' a Customer name stored in MongoDB through DAO ",
            response = ResponseEntity.class,
            tags = "PATCHCustomerUpdateUsernameDAO")
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



    @ApiOperation(
            value = "PATCH request, passing Admin Info, for 'patching' a Customer email stored in MongoDB through arguments ",
            response = ResponseEntity.class,
            tags = "PATCHCustomerUpdateUserEmailArguments")
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



    @ApiOperation(
            value = "PATCH request, passing Admin Info, for 'patching' a Customer email stored in MongoDB through HTTP request Body ",
            response = ResponseEntity.class,
            tags = "PATCHCustomerUpdateEmailDAO")
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



    @ApiOperation(
            value = "PATCH request, passing Admin Info, for 'patching' a Customer password stored in MongoDB through arguments ",
            response = ResponseEntity.class,
            tags = "PATCHCustomerUpdatePasswordArguments")
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



    @ApiOperation(
            value = "PATCH request, passing Admin Info, for 'patching' a Customer password stored in MongoDB through Http request Body ",
            response = ResponseEntity.class,
            tags = "PATCHCustomerUpdatePassworDAO")
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
