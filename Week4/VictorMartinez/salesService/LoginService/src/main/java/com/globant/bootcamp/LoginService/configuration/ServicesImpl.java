package com.globant.bootcamp.LoginService.configuration;

import com.globant.bootcamp.LoginService.domain.Customer;
import com.globant.bootcamp.LoginService.repository.CustomerRepository;
import com.globant.bootcamp.LoginService.repository.LoginServiceRepository;
import com.globant.bootcamp.LoginService.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.globant.bootcamp.LoginService.utils.UtilConstants.*;

@Service
public class ServicesImpl implements Services {


    private LoginServiceRepository loginServiceRepository;

    @Autowired
    private CustomerRepository customerRepository;



    public ServicesImpl(){}

    @Autowired
    public ServicesImpl(LoginServiceRepository loginServiceRepository){
        super();
        this.loginServiceRepository = loginServiceRepository;
    }


    @Override
    public boolean allowAccessByName(String username, String password) {

        try {
            return !this.loginServiceRepository.getAccountByName(username).equals(null) &&
                    this.loginServiceRepository.getAccountByName(username).getPassword().equals(password);
        }catch(NullPointerException exception) {
            return false;
        }
    }

    @Override
    public boolean allowAccessByEmail(String userEmail, String password) {

        try {
            return !this.loginServiceRepository.getAccountByEmail(userEmail).equals(null) &&
                    this.loginServiceRepository.getAccountByEmail(userEmail).getPassword().equals(password);
        }catch (NullPointerException exception){
            return false;
        }
    }

    @Override
    public HashMap<String, Account> processRequestGetAllUsers(){

        return this.loginServiceRepository.getAllUsers();

    }

    @Override
    public Account getVerifiedUserAccountByName(String username) {

        return this.loginServiceRepository.getAccountByName(username);
    }

    @Override
    public Account getVerifiedUserAccountByEmail(String username) {

        return this.loginServiceRepository.getAccountByEmail(username);
    }

    @Override
    public boolean correctSyntaxUsername(String userName){

        Pattern  forbiddenCharacters = Pattern.compile("[/*$%+,:;=?¿!¡@#|\\s]");
        Matcher matcher = forbiddenCharacters.matcher(userName);
        return !matcher.find();
    }

    @Override
    public boolean correctSyntaxPassword(String password){

        Pattern  forbiddenCharacters = Pattern.compile("[/*$%+,:;=?¿!¡@#|\\s]");
        Matcher matcher = forbiddenCharacters.matcher(password);
        return !matcher.find();
    }

    @Override
    public boolean correctSyntaxEmail(String userEmail){

        Pattern  forbiddenCharacters = Pattern.compile("[/*$%+,:;=?¿!¡#|\\s]");

        Matcher matcher = forbiddenCharacters.matcher(userEmail);
        return !matcher.find();
    }

    @Override
    public boolean validRolRequest(String rol, String username, String password){

        if(!rol.equals(ROLE_ADMIN)) return false;
        return allowAccessByName(username, password);
    }

    @Override
    public Account requestAddNewUser(Account newAccount){

        try {
            return this.loginServiceRepository.addAccountByName(newAccount);
        }catch(Exception exception){
            return null;
        }
    }

    @Override
    public Account processRequestUpdateUserByName(Account updateUser){

        try{
            return this.loginServiceRepository.updateAccountByName(updateUser);
        }catch(Exception exception){
            return null;
        }
    }

    @Override
    public Account processRequestDeleteUserByName(String deleteUsername){

        return this.loginServiceRepository.deleteAccountByName(deleteUsername);
    }

    @Override
    public Account processRequestDeleteUserByEmail(String deleteUsername){

        return this.loginServiceRepository.deleteAccountByEmail(deleteUsername);
    }

    @Override
    public Account processRequestUpdateName(String username, String newProperty) {

        return this.loginServiceRepository.updateAccountProperty(PROPERTY_NAME, username, newProperty);
    }

    @Override
    public Account processRequestUpdateEmail(final String username, final String newProperty){

        return this.loginServiceRepository.updateAccountProperty(PROPERTY_EMAIL, username, newProperty);
    }


    @Override
    public Account processRequestUpdatePassword(final String username, final String newProperty){

        return this.loginServiceRepository.updateAccountProperty(PROPERTY_PASSWORD, username, newProperty);
    }



    public Customer getCustomerInfoByUsername(final String username){
        return this.customerRepository.findByUsername(username);

    }

}
