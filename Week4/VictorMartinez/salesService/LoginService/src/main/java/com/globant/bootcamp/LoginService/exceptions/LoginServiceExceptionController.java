package com.globant.bootcamp.LoginService.exceptions;

import com.globant.bootcamp.LoginService.data.AccountDAO_LoginService;
import com.globant.bootcamp.LoginService.data.AccountMultiplDAO_LoginService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoginServiceExceptionController {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<AccountDAO_LoginService> exception(UserNotFoundException exception){
        return ResponseEntity
                .badRequest()
                .header("LoginService", "UserNotFound Exception")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService(exception.getMessage(), "UserNotFound Exception", null));
    }

    @ExceptionHandler(value = InvalidUsernameException.class)
    public ResponseEntity<AccountDAO_LoginService> exception(InvalidUsernameException exception){
        //return new ResponseEntity<>(exception.getMsg(), HttpStatus.BAD_REQUEST);
        return ResponseEntity
                .badRequest()
                .header("LoginService", "InvalidUser Exception")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService(exception.getMessage(), "InvalidUser Exception", null));
    }

    @ExceptionHandler(value = WrongPasswordException.class)
    public ResponseEntity<AccountDAO_LoginService> exception(WrongPasswordException exception){
        return ResponseEntity
                .badRequest()
                .header("LoginService", "WrongPassword Exception")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService(exception.getMessage(), "WrongPassword Exception", null));
    }

    @ExceptionHandler(value = InvalidPasswordException.class)
    public ResponseEntity<AccountDAO_LoginService> exception(InvalidPasswordException exception){
        return ResponseEntity
                .badRequest()
                .header("LoginService", "InvalidPassword Exception")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService(exception.getMessage(), "InvalidPassword Exception", null));
    }

    @ExceptionHandler(value = InvalidEmailException.class)
    public ResponseEntity<AccountDAO_LoginService> exception(InvalidEmailException exception){
        return ResponseEntity
                .badRequest()
                .header("LoginService", "InvalidEmail Exception")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService(exception.getMessage(), "InvalidEmail Exception", null));
    }

    @ExceptionHandler(value = EmailNotFoundException.class)
    public ResponseEntity<AccountDAO_LoginService> exception(EmailNotFoundException exception){
        return ResponseEntity
                .badRequest()
                .header("LoginService", "EmailNotFound Exception")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService(exception.getMessage(), "EmailNotFound Exception", null));
    }

    @ExceptionHandler(value = EmptyAccountException.class)
    public ResponseEntity<AccountDAO_LoginService> exception(EmptyAccountException exception){
        return ResponseEntity
                .badRequest()
                .header("LoginService", "EmptyAccount Exception")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService(exception.getMessage(), "EmptyAccount Exception", null));
    }

    @ExceptionHandler(value = InvalidnewuserUsernameException.class)
    public ResponseEntity<AccountDAO_LoginService> exception(InvalidnewuserUsernameException exception){
        return ResponseEntity
                .badRequest()
                .header("LoginService", "InvalidnewuserUserName Exception")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService(exception.getMessage(), "InvalidnewuserUserName Exception", null));
    }

    @ExceptionHandler(value = InvalidnewuserPasswordException.class)
    public ResponseEntity<AccountDAO_LoginService> exception(InvalidnewuserPasswordException exception){
        return ResponseEntity
                .badRequest()
                .header("LoginService", "InvalidnewuserPassword Exception")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService(exception.getMessage(), "InvalidnewuserPassword Exception", null));
    }

    @ExceptionHandler(value = WrongValidationException.class)
    public ResponseEntity<AccountDAO_LoginService> exception(WrongValidationException exception){
        return ResponseEntity
                .badRequest()
                .header("LoginService", "WrongValidation Exception")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService(exception.getMessage(), "WrongValidation Exception", null));
    }

    @ExceptionHandler(value = InvalidUserToBeAdded.class)
    public ResponseEntity<AccountDAO_LoginService> exception(InvalidUserToBeAdded exception){
        return ResponseEntity
                .badRequest()
                .header("LoginService", "InvalidUser Exception")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountDAO_LoginService(exception.getMessage(), "InvalidUser Exception", null));
    }

    @ExceptionHandler(value = EmptyAccountsExceptions.class)
    public ResponseEntity<AccountMultiplDAO_LoginService> exception(EmptyAccountsExceptions exception){
        return ResponseEntity
                .badRequest()
                .header("LoginService", "Not Accounts Registered Exception")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountMultiplDAO_LoginService(exception.getMessage(), "Not Accounts Registered Exception", null));
    }

    @ExceptionHandler(value = InvalidnewuserEmailException.class)
    public ResponseEntity<AccountMultiplDAO_LoginService> exception(InvalidnewuserEmailException exception){
        return ResponseEntity
                .badRequest()
                .header("LoginService", "Invalid Email presented by the New User")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new AccountMultiplDAO_LoginService(exception.getMessage(), "Invalid Email presented by the New User", null));
    }







}
