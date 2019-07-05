package com.globant.bootcamp.LoginService.repository;

import com.globant.bootcamp.LoginService.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


public interface LoginServiceRepository {

    Account getAccountByName(final String username);
    Account getAccountByEmail(final String username);
    Account addAccountByName(final Account newAccount);
    Account updateAccountByName(final Account updateUser);
    Account deleteAccountByName(final String deleteUsername);
    Account deleteAccountByEmail(final String deleteUsername);
    Account updateAccountProperty(String property, String username, String newProperty);
    HashMap<String, Account> getAllUsers();



}
