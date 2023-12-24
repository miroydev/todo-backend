package com.user.service.userservice.model.User.Account;


public class AccountModel {
    private String username;
    private String fullName;
    private String birthdate;
    private String address;
    private String gender;

    
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AccountModel() {
    }



    public String getUsername() {
        return username;
    }
    public String getFullName() {
        return fullName;
    }
    public String getBirthdate() {
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








