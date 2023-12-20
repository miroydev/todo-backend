package com.user.service.userservice.model.User.Account;
import java.sql.Date;


public class AccountModel {
    private String id;
    private String username;
    private String fullName;
    private Date birthdate;
    private String address;
    private String gender;


    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    public String getFullName() {
        return fullName;
    }
    public Date getBirthdate() {
        return birthdate;
    }
    public String getAddress() {
        return address;
    }
    public String getGender() {
        return gender;
    }


    @Override
    public String toString() {
        return "AccountModel []";
    }

    
}








