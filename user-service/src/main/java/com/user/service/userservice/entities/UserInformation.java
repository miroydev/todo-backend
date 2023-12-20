package com.user.service.userservice.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;


@Document(collection = "todo_users")
public class UserInformation {
    
    @Id
    private String id;

    @NotBlank(message = "UserName cannot be empty")
    @Field("user_name")
    private String userName;

    @NotBlank(message = "email cannot be empty")
    @Field("user_email")
    private String email;

    @NotBlank(message = "HashPassword cannot be empty")
    @Field("user_hashPassword")
    private String HashPassword;

    @NotBlank(message = "fullName cannot be empty")
    @Field("user_fullName")
    private String fullName;

    @NotBlank(message = "birthdate cannot be empty")
    @Field("user_birthdate")
    private String birthdate;

    @NotBlank(message = "Address cannot be empty")
    @Field("user_address")
    private String address;

    @NotBlank(message = "gender cannot be empty")
    @Field("user_gender")
    private String gender;
    
    @Field("creation_date")
    private String creationDate;

    public UserInformation(@NotBlank(message = "UserName cannot be empty") String userName,
            @NotBlank(message = "email cannot be empty") String email,
            @NotBlank(message = "HashPassword cannot be empty") String hashPassword,
            @NotBlank(message = "fullName cannot be empty") String fullName,
            @NotBlank(message = "birthdate cannot be empty") String birthdate,
            @NotBlank(message = "Address cannot be empty") String address,
            @NotBlank(message = "gender cannot be empty") String gender, String creationDate) {
        this.userName = userName;
        this.email = email;
        HashPassword = hashPassword;
        this.fullName = fullName;
        this.birthdate = birthdate;
        this.address = address;
        this.gender = gender;
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    } 

    
   
}
