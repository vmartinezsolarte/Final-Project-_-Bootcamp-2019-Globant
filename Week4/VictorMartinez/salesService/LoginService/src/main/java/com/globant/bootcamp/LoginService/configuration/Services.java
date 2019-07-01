package com.globant.bootcamp.LoginService.configuration;

import com.globant.bootcamp.LoginService.domain.Account;
import com.globant.bootcamp.LoginService.domain.Customer;

import java.util.HashMap;

public interface Services {

    boolean allowAccessByName(final String username, final String password);
    boolean allowAccessByEmail(final String userEmail, final  String password);
    Account getVerifiedUserAccountByName(final String username);
    Account getVerifiedUserAccountByEmail(final String username);
    public boolean correctSyntaxUsername(final String password);
    public boolean correctSyntaxPassword(final String password);
    public boolean correctSyntaxEmail(final String password);
    public boolean validRolRequest(final String rol, final String username, final String password);
    public Account requestAddNewUser(final Account newAccount);
    public HashMap<String, Account> processRequestGetAllUsers();
    public Account processRequestUpdateUserByName(final Account updateUser);
    public Account processRequestDeleteUserByName(final String deleteUsername);
    public Account processRequestDeleteUserByEmail(final String deleteUsername);
    public Account processRequestUpdateName(final String username, final String newProperty);
    public Account processRequestUpdateEmail(final String username, final String newProperty);
    public Account processRequestUpdatePassword(final String username, final String newProperty);
    public Customer getCustomerInfo(final String username);

}

