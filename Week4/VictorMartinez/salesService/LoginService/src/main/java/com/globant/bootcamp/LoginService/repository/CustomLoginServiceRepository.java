package com.globant.bootcamp.LoginService.repository;




import com.globant.bootcamp.LoginService.data.DataSource;
import com.globant.bootcamp.LoginService.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class CustomLoginServiceRepository implements LoginServiceRepository {

    @Autowired
    private DataSource dataSource;

    public CustomLoginServiceRepository(){}

    @Override
    public Account getAccountByName(String username) { return dataSource.retrieveUserInformationByName(username); }

    @Override
    public Account getAccountByEmail(String userEmail) {
        return dataSource.retrieveUserInformationByEmail(userEmail);
    }

    @Override
    public Account addAccountByName(Account newAccount) { return dataSource.addUserAccount(newAccount);   }

    @Override
    public HashMap<String, Account> getAllUsers(){return dataSource.getAllUsers();}

    @Override
    public Account updateAccountByName(Account updateUser){ return  dataSource.updateUserAccount(updateUser);}

    @Override
    public Account deleteAccountByName(String deleteUsername){ return dataSource.deleteUserByName(deleteUsername); }

    @Override
    public Account deleteAccountByEmail(String deleteUserEmail){ return dataSource.deleteUserByEmail(deleteUserEmail); }

    @Override
    public Account updateAccountProperty(String property, String username, String newProperty) {
        switch (property){
            case "name"     : return dataSource.updateUserAccountName(username, newProperty);
            case "email"    : return dataSource.updateUserAccountEmail(username, newProperty);
            case "password" : return dataSource.updateUserAccountPassword(username, newProperty);
            default : break;
        }
        return null;
    }


}
