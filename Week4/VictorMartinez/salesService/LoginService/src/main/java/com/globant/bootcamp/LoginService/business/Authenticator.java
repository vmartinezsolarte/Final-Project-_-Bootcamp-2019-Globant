package com.globant.bootcamp.LoginService.business;

import com.globant.bootcamp.LoginService.data.AccountDAO_LoginService;
import com.globant.bootcamp.LoginService.data.AccountMultiplDAO_LoginService;
import com.globant.bootcamp.LoginService.data.CustomerDAO_LoginService;
import com.globant.bootcamp.LoginService.domain.Account;
import org.springframework.http.ResponseEntity;


public interface Authenticator {


    boolean authenticateByName(final String username, final String password);
    boolean authenticateByEmail(final String userEmail, final String password);
    String retrieveStringAccount(final String username);
    ResponseEntity<CustomerDAO_LoginService> retrieveAccountByName(final String username);
    ResponseEntity<CustomerDAO_LoginService> validateRequestByName(final String username, final String password);
    ResponseEntity<AccountDAO_LoginService>  retrieveAccountByEmail(final String userEmail);
    ResponseEntity<AccountDAO_LoginService> validateRequestByEmail(final String userEmail, String password);
    ResponseEntity<CustomerDAO_LoginService> processRequestByName(final String username,final String password);
    ResponseEntity<AccountDAO_LoginService> processRequestByEmail(final String username, String password);
    ResponseEntity<AccountDAO_LoginService> processRequestAddUserByName(final String rol, final String username, final String password, final Account newAccount);
    ResponseEntity<AccountDAO_LoginService> addUserRequestByName(final Account newAccount);
    ResponseEntity<AccountMultiplDAO_LoginService>processRequestGetAllUsers(final String rol, final String name, final String password);
    ResponseEntity<AccountMultiplDAO_LoginService> getAllUsers();
    ResponseEntity<AccountDAO_LoginService> processRequestupdateUserByName(final String rol, final String rolname, final String rolpassword, final String username, final Account updateAccount);
    ResponseEntity<AccountDAO_LoginService> updateUserByName(Account updateUser);
    ResponseEntity<AccountDAO_LoginService> processRequestDeleteUserByName(final String rol, final String rolname, final String rolpassword, final String deleteUsername);
    ResponseEntity<AccountDAO_LoginService> processRequestDeleteUserByEmail(final String rol, final String rolname, final String rolpassword, final String deleteUserEmail);
    ResponseEntity<AccountDAO_LoginService> deleteUserByName(final String deleteUsername);
    ResponseEntity<AccountDAO_LoginService> deleteUserByEmail(final String deleteUserEmail);
    ResponseEntity<AccountDAO_LoginService> processRequestUpdateName(final String rol, final String rolname, final String rolpassword, final String oldUsername, final String newUsername);
    ResponseEntity<AccountDAO_LoginService> processRequestUpdateNewEmail(final String rol, final String rolname, final String rolpassword, final String username, final String newUserEmail);
    ResponseEntity<AccountDAO_LoginService> processRequestUpdateNewPassword(final String rol, final String rolname, final String rolpassword, final String username, final String newPassword);
    ResponseEntity<AccountDAO_LoginService> updateEmail(final String username, final String newUserEmail);
    ResponseEntity<AccountDAO_LoginService> updateName(final String oldUsername, final String newUsername);
    ResponseEntity<AccountDAO_LoginService> updatePassword(final String username, final String newUserPassword);




}
