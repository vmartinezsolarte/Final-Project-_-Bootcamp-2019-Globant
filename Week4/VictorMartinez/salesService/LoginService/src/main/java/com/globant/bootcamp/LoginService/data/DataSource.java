package com.globant.bootcamp.LoginService.data;

import com.globant.bootcamp.LoginService.domain.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


//@Service
@Component
@Qualifier("DataSource")
public class DataSource {


    HashMap<String, Account> usersInfo;



    public DataSource(){
        usersInfo = new HashMap<>();

        usersInfo.put("Andres", new Account("Andres", "1234", "an@un.edu.co"));
        usersInfo.put("Antonio",new Account("Antonio", "absd", "to@un.edu.co"));
        usersInfo.put("Mike", new Account("Mike","secret", "m@ls.edu.co"));
        usersInfo.put("Tony", new Account("Tony","Stark", "starks@tony.com"));
        usersInfo.put("Juan", new Account("Juan","060754", "Juanloco@hotmail.com"));
        usersInfo.put("Andrea", new Account("Andrea","I<3NY", "Andrealoca@gmail.com"));
        usersInfo.put("Natalia", new Account("Natalia","SailorMoon", "Sailor76@exu.com"));
        usersInfo.put("Luis", new Account("Luis", "Functional", "luchito4ever@yahoo.es"));
        usersInfo.put("carlo123", new Account("carlos123", "1234", "carlitos@un.edu.co" ));
    }




    public HashMap<String, Account> getAllUsers(){
        return this.usersInfo;
    }

    public Account retrieveUserInformationByName(String username){

        if(usersInfo.containsKey(username)){
            return new Account(username, usersInfo.get(username).getPassword(), usersInfo.get(username).getEmail());
        }
        else {
            return null;
        }
    }

    public Account retrieveUserInformationByEmail(String userEmail){

        for(Account userInfo : usersInfo.values()){
            if(userInfo.getEmail().equals(userEmail)){
                return new Account(
                        userInfo.getUsername(),
                        userInfo.getPassword(),
                        userInfo.getEmail());}
        }
        return null;
    }

    public String getPassWord(String username){
        return usersInfo.get(username).getPassword();
    }

    public String getEmail(String username){ return usersInfo.get(username).getEmail();}

    public Account deleteUserByName(String username){

        if (usersInfo.containsKey(username)){ usersInfo.remove(username);  return null;} else{ return new Account("-", "-", "-");}
    }

    public Account deleteUserByEmail(String email){

        for(Account userInfo : usersInfo.values()){
            if (userInfo.getEmail().equals(email)){ usersInfo.remove(userInfo.getUsername()); return null;}}
        return new Account("-", "-", "-");
    }

    public Account addUserAccount(Account newUser){

        if(newUser==null){ return null;}
        if(this.usersInfo.containsKey(newUser.getUsername())){return null;}
        this.usersInfo.put(newUser.getUsername(), newUser);
        return this.usersInfo.get(newUser.getUsername());
    }

    /// These are missing for validation - > DataSource shouldn't make it but Services.
    public Account updateUserAccount(Account newUser){

        if(newUser== null){ return null;}
        if(!usersInfo.containsKey(newUser.getUsername())){return null;}
        this.usersInfo.remove(newUser.getUsername());
        this.usersInfo.put(newUser.getUsername(), newUser);
        return this.usersInfo.get(newUser.getUsername());
    }

    public Account updateUserAccountName(String Oldusername, String newUsername){

        if(!this.usersInfo.containsKey(Oldusername)){return null;}
        this.usersInfo.put(newUsername, new Account(newUsername, usersInfo.get(Oldusername).getPassword(), usersInfo.get(Oldusername).getEmail()));
        this.usersInfo.remove(Oldusername);
        return this.usersInfo.get(newUsername);
    }

    public Account updateUserAccountPassword(String username, String newPassWord){

        if(!this.usersInfo.containsKey(username)){return null;}
        Account newUserPassWord = new Account(username, newPassWord, usersInfo.get(username).getEmail());
        this.usersInfo.remove(username);
        this.usersInfo.put(username, newUserPassWord);
        return this.usersInfo.get(username);
    }

    public Account updateUserAccountEmail(String username, String newEmail){

        if(!this.usersInfo.containsKey(username)){return null;}
        Account newUserEmail = new Account(username, usersInfo.get(username).getPassword(), newEmail);
        this.usersInfo.remove(username);
        this.usersInfo.put(username, newUserEmail);
        return this.usersInfo.get(username);
    }

    public List<String> getAllUsersInfo(){

        ArrayList<String> names = new ArrayList<String>(usersInfo.keySet());
        return names;
    }

}
