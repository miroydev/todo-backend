package com.user.service.userservice.model.User.registration;

public class RegistrationModel {

    private String userName;
    private String fullName;
    private String birthdate;
    private String address;
    private String gender;
    private String email;
    private String password;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    
}
