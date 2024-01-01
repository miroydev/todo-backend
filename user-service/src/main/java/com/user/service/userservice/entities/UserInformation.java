package com.user.service.userservice.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "user_information")
public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userinformation_id")
    private int id;

    @NotBlank(message = "fullName cannot be empty")
    @Column(name = "user_fullname")
    private String fullName;

    @NotBlank(message = "birthdate cannot be empty")
    @Column(name = "user_birthdate")
    private String birthdate;

    @NotBlank(message = "Address cannot be empty")
    @Column(name = "user_address")
    private String address;

    @NotBlank(message = "gender cannot be empty")
    @Column(name = "user_gender")
    private String gender;
    
    //@Transient
    @CreationTimestamp
    @Column(name = "creation_date", nullable = false)
    private Timestamp creationDate;
    

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userinformation_id")
    private UserCredentials credentials;

    
    

    public UserInformation() {
    }

    public UserInformation(@NotBlank(message = "fullName cannot be empty") String fullName,
            @NotBlank(message = "birthdate cannot be empty") String birthdate,
            @NotBlank(message = "Address cannot be empty") String address,
            @NotBlank(message = "gender cannot be empty") String gender) {
        this.fullName = fullName;
        this.birthdate = birthdate;
        this.address = address;
        this.gender = gender;
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



    public void setCredentials(UserCredentials credentials) {
        this.credentials = credentials;
    } 

    
}
