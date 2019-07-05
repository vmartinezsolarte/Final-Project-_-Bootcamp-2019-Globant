package com.globant.bootcamp.LoginService.configuration;

import com.globant.bootcamp.LoginService.domain.Account;
import com.globant.bootcamp.LoginService.domain.Customer;

import java.util.HashMap;

public interface Services {

    boolean allowAccessByName(final String username, final String password);
    boolean allowAccessByEmail(final String userEmail, final  String password);
    Account getVerifiedUserAccountByName(final String username);
    Account getVerifiedUserAccountByEmail(final String username);
    boolean correctSyntaxUsername(final String password);
    boolean correctSyntaxPassword(final String password);
    boolean correctSyntaxEmail(final String password);
    boolean validRolRequest(final String rol, final String username, final String password);
    Account requestAddNewUser(final Account newAccount);
    HashMap<String, Account> processRequestGetAllUsers();
    Account processRequestUpdateUserByName(final Account updateUser);
    Account processRequestDeleteUserByName(final String deleteUsername);
    Account processRequestDeleteUserByEmail(final String deleteUsername);
    Account processRequestUpdateName(final String username, final String newProperty);
    Account processRequestUpdateEmail(final String username, final String newProperty);
    Account processRequestUpdatePassword(final String username, final String newProperty);
    Customer getCustomerInfoByUsername(final String username);

}

