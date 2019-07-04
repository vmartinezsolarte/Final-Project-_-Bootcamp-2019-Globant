package com.globant.bootcamp.LoginService.business;

import com.globant.bootcamp.LoginService.data.CustomerDAO_LoginService;
import com.globant.bootcamp.LoginService.domain.Customer;
import com.globant.bootcamp.LoginService.exceptions.*;
import com.globant.bootcamp.LoginService.configuration.Services;
import com.globant.bootcamp.LoginService.data.AccountDAO_LoginService;
import com.globant.bootcamp.LoginService.data.AccountMultiplDAO_LoginService;
import com.globant.bootcamp.LoginService.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class AuthenticatorImpl implements  Authenticator {


    private Services serviceImpl;



    @Autowired
    public AuthenticatorImpl (final Services serviceImpl ){
        this.serviceImpl     =   serviceImpl;
    }


    @Override
    public boolean authenticateByName(final String username, final String password) {

        return (this.serviceImpl.allowAccessByName(username, password));

    }

    @Override
    public boolean authenticateByEmail(final String userEmail, final String password) {

        return (this.serviceImpl.allowAccessByEmail(userEmail, password));

    }

    @Override
    public String retrieveStringAccount(String username) {
        return null;
    }

    @Override
    public ResponseEntity<CustomerDAO_LoginService> validateRequestByName(
            final String username,
            final String password){

         if (!this.authenticateByName(username, password)) throw new WrongPasswordException();
         return this.retrieveAccountByName(username);
    }

    @Override
    public ResponseEntity<AccountDAO_LoginService> validateRequestByEmail(
            final String userEmail,
            final String password){

        if (!this.authenticateByEmail(userEmail, password)) throw new WrongPasswordException();
        return this.retrieveAccountByEmail(userEmail);
    }

    @Override
    public ResponseEntity<CustomerDAO_LoginService> processRequestByName(
            final String username,
            final String password){
        System.out.println("UserName" + username);
        System.out.println("Password" + password);


        if(!this.serviceImpl.correctSyntaxUsername(username)) throw new InvalidUsernameException();
        if(!this.serviceImpl.correctSyntaxPassword(password)) throw new InvalidPasswordException();
        return this.validateRequestByName(username, password);
    }

    @Override
    public ResponseEntity<AccountDAO_LoginService> processRequestByEmail(
            final String userEmail,
            final String password){

        if(!this.serviceImpl.correctSyntaxEmail(userEmail)) throw new InvalidEmailException();
        if(!this.serviceImpl.correctSyntaxPassword(password)) throw new InvalidPasswordException();
        return this.validateRequestByEmail(userEmail, password);
    }

    @Override
    public ResponseEntity<AccountDAO_LoginService> processRequestAddUserByName(
            final String rol,
            final String username,
            final String password,
            final Account newAccount){

        if(!this.serviceImpl.correctSyntaxUsername(username)) throw new InvalidUsernameException();
        if(!this.serviceImpl.correctSyntaxPassword(password)) throw new InvalidPasswordException();
        if(!this.serviceImpl.correctSyntaxUsername(newAccount.getUsername())) throw new InvalidnewuserUsernameException();
        if(!this.serviceImpl.correctSyntaxPassword(newAccount.getPassword())) throw new InvalidnewuserPasswordException();
        if (!this.serviceImpl.validRolRequest(rol, username, password)) throw  new WrongValidationException();

        return this.addUserRequestByName(newAccount);
    }

    @Override
    public ResponseEntity<AccountMultiplDAO_LoginService>processRequestGetAllUsers(
            final String rol,
            final String username,
            final String password){

        if(!this.serviceImpl.correctSyntaxUsername(username)) throw new InvalidUsernameException();
        if(!this.serviceImpl.correctSyntaxPassword(password)) throw new InvalidPasswordException();
        if (!this.serviceImpl.validRolRequest(rol, username, password)) throw  new WrongValidationException();

        return this.getAllUsers();
    }

    @Override
    public ResponseEntity<AccountDAO_LoginService> processRequestupdateUserByName(
           final String rol,
           final String rolname,
           final String rolpassword,
           final String username,
           final Account updateAccount){

        if(!this.serviceImpl.correctSyntaxUsername(rolname)) throw new InvalidUsernameException();
        if(!this.serviceImpl.correctSyntaxPassword(rolpassword)) throw new InvalidPasswordException();
        if(!this.serviceImpl.correctSyntaxUsername(updateAccount.getUsername())) throw new InvalidnewuserUsernameException();
        if(!this.serviceImpl.correctSyntaxPassword(updateAccount.getPassword())) throw new InvalidnewuserPasswordException();
        if(!this.serviceImpl.correctSyntaxEmail(updateAccount.getEmail())) throw new InvalidnewuserEmailException();
        if (!this.serviceImpl.validRolRequest(rol, rolname, rolpassword)) throw  new WrongValidationException();

        return this.updateUserByName(updateAccount);
    }
    @Override
    public ResponseEntity<AccountDAO_LoginService> processRequestDeleteUserByName(
            final String rol,
            final String rolname,
            final String rolpassword,
            final String deleteUsername){

        if(!this.serviceImpl.correctSyntaxUsername(rolname)) throw new InvalidUsernameException();
        if(!this.serviceImpl.correctSyntaxPassword(rolpassword)) throw new InvalidPasswordException();
        if (!this.serviceImpl.validRolRequest(rol, rolname, rolpassword)) throw  new WrongValidationException();
        if(!this.serviceImpl.correctSyntaxUsername(deleteUsername)) throw new InvalidnewuserUsernameException();
        return this.deleteUserByName(deleteUsername);
    }
    @Override
    public ResponseEntity<AccountDAO_LoginService> processRequestDeleteUserByEmail(
            final String rol,
            final String rolname,
            final String rolpassword,
            final String deleteUserEmail){

        if(!this.serviceImpl.correctSyntaxUsername(rolname)) throw new InvalidUsernameException();
        if(!this.serviceImpl.correctSyntaxPassword(rolpassword)) throw new InvalidPasswordException();
        if (!this.serviceImpl.validRolRequest(rol, rolname, rolpassword)) throw  new WrongValidationException();
        if(!this.serviceImpl.correctSyntaxEmail(deleteUserEmail)) throw new InvalidnewuserEmailException();
        return this.deleteUserByEmail(deleteUserEmail);

    }

    @Override
    public ResponseEntity<AccountDAO_LoginService> processRequestUpdateName(
            final String rol,
            final String rolname,
            final String rolpassword,
            final String oldUsername,
            final String newUsername){

        if(!this.serviceImpl.correctSyntaxUsername(rolname)) throw new InvalidUsernameException();
        if(!this.serviceImpl.correctSyntaxPassword(rolpassword)) throw new InvalidPasswordException();
        if (!this.serviceImpl.validRolRequest(rol, rolname, rolpassword)) throw  new WrongValidationException();
        if(!this.serviceImpl.correctSyntaxUsername(oldUsername)) throw new InvalidUsernameException();
        if(!this.serviceImpl.correctSyntaxUsername(newUsername)) throw new InvalidnewuserEmailException();

        return this.updateName(oldUsername, newUsername);
    }


    @Override
    public ResponseEntity<AccountDAO_LoginService> processRequestUpdateNewEmail(
            final String rol,
            final String rolname,
            final String rolpassword,
            final String username,
            final String newUserEmail){

        if(!this.serviceImpl.correctSyntaxUsername(rolname)) throw new InvalidUsernameException();
        if(!this.serviceImpl.correctSyntaxPassword(rolpassword)) throw new InvalidPasswordException();
        if (!this.serviceImpl.validRolRequest(rol, rolname, rolpassword)) throw  new WrongValidationException();
        if(!this.serviceImpl.correctSyntaxUsername(username)) throw new InvalidnewuserUsernameException();
        if(!this.serviceImpl.correctSyntaxEmail(newUserEmail)) throw new InvalidnewuserEmailException();

        return this.updateEmail(username, newUserEmail);
    }


    public ResponseEntity<AccountDAO_LoginService> processRequestUpdateNewPassword(
            final String rol,
            final String rolname,
            final String rolpassword,
            final String username,
            final String newPassword){

        if(!this.serviceImpl.correctSyntaxUsername(rolname)) throw new InvalidUsernameException();
        if(!this.serviceImpl.correctSyntaxPassword(rolpassword)) throw new InvalidPasswordException();
        if (!this.serviceImpl.validRolRequest(rol, rolname, rolpassword)) throw  new WrongValidationException();
        if(!this.serviceImpl.correctSyntaxUsername(username)) throw new InvalidnewuserUsernameException();
        if(!this.serviceImpl.correctSyntaxPassword(newPassword)) throw new InvalidnewuserPasswordException();

        return this.updatePassword(username, newPassword);
    }

    @Override
    public ResponseEntity<CustomerDAO_LoginService> retrieveAccountByName(final String username){

        Account accountSearched = this.serviceImpl.getVerifiedUserAccountByName(username);
        if(accountSearched== null) throw new UserNotFoundException();
        System.out.println("Passed first DB - Data Source");
        Customer customerSearched = this.serviceImpl.getCustomerInfoByUsername(username);
        System.out.println("User found =? "+ customerSearched.getFirstname());
        System.out.println("Testing second DB - Customer");
        return ResponseEntity.accepted()
                .header("LogingService", "UserFound")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new CustomerDAO_LoginService("UserFound", "Customer", customerSearched));
    }

    @Override
    public ResponseEntity<AccountDAO_LoginService> retrieveAccountByEmail(final String userEmail){

        Account accountSearched = this.serviceImpl.getVerifiedUserAccountByEmail(userEmail);
        if(accountSearched== null) throw new UserNotFoundException();
        return ResponseEntity.accepted()
                .header("LogingService", "UserFound")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService("UserFound", "Account", accountSearched ));
    }

    @Override
    public ResponseEntity<AccountDAO_LoginService> addUserRequestByName(Account newAccount) {

        Account accountAdded = this.serviceImpl.requestAddNewUser(newAccount);
        if(accountAdded== null) throw new UserNotFoundException();
        return ResponseEntity.accepted()
                .header("LogingService", "UserAdded")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService("UserAdded", "newUser Added", newAccount ));
    }
    @Override
    public ResponseEntity<AccountMultiplDAO_LoginService> getAllUsers(){

        HashMap<String,Account> accountsLists = this.serviceImpl.processRequestGetAllUsers();
        if(accountsLists== null) throw new EmptyAccountsExceptions();
        return ResponseEntity.accepted()
                .header("LogingService", "Getting All Users")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountMultiplDAO_LoginService("Getting all Users", "Users info", accountsLists ));
    }

    @Override
    public ResponseEntity<AccountDAO_LoginService> updateUserByName(Account updateUser){

        Account updatedAccount = this.serviceImpl.processRequestUpdateUserByName(updateUser);
        if(updatedAccount== null) throw new UserNotFoundException();
        return ResponseEntity.accepted()
                .header("LogingService", "Updating User By Name")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService("Updating User By Name", "User updated Succesfully", updatedAccount ));
    }

    @Override
    public ResponseEntity<AccountDAO_LoginService> deleteUserByName(final String deleteUsername){
        Account deletedAccount = this.serviceImpl.processRequestDeleteUserByName(deleteUsername);
        if(deletedAccount!= null) throw new UserNotFoundException();
        return ResponseEntity.accepted()
                .header("LogingService", "Deleting User By Name")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService("Deleting User By Name", "User deleted Succesfully", deletedAccount));
    }

    @Override
    public ResponseEntity<AccountDAO_LoginService> deleteUserByEmail(final String deleteUserEmail){
        Account deletedAccount = this.serviceImpl.processRequestDeleteUserByEmail(deleteUserEmail);
        if(deletedAccount!= null) throw new UserNotFoundException();
        return ResponseEntity.accepted()
                .header("LogingService", "Deleting User By Email")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService("Deleting User By Name", "User deleted Succesfully", deletedAccount));

    }

    @Override
    public ResponseEntity<AccountDAO_LoginService> updateName (final String oldUsername, final String newUsername){

        Account updateNameAccount = this.serviceImpl.processRequestUpdateName(oldUsername, newUsername);
        if(updateNameAccount == null) throw new UserNotFoundException();
        return ResponseEntity.accepted()
                .header("LogingService", "Updating User Name")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService("Updating user Name", "Name updated Succesfully", updateNameAccount));

    }

    @Override
    public ResponseEntity<AccountDAO_LoginService> updateEmail (final String username, final String newUserEmail){

        Account updateEmailAccount = this.serviceImpl.processRequestUpdateEmail(username, newUserEmail);
        if(updateEmailAccount == null) throw new EmailNotFoundException();
        return ResponseEntity.accepted()
                .header("LogingService", "Updating User Email ")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService("Updating user Email", "Email updated Succesfully", updateEmailAccount));
    }

    @Override
    public ResponseEntity<AccountDAO_LoginService> updatePassword (final String username, final String newUserPassword){

        Account updatePasswordAccount = this.serviceImpl.processRequestUpdatePassword(username, newUserPassword);
        if(updatePasswordAccount == null) throw new EmailNotFoundException();
        return ResponseEntity.accepted()
                .header("LogingService", " Updating User PassWord ")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService("Updating user PassWord", "Password updated Succesfully", updatePasswordAccount));
    }
}
