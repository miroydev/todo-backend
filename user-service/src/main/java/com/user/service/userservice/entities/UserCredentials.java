package com.user.service.userservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Id;

@Entity
@Table(name = "user_credentials")
public class UserCredentials {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "credential_id")
	private int id;

    @NotBlank(message = "UserName cannot be empty")
    @Column(name = "username")
    private String userName;

    @NotBlank(message = "email cannot be empty")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "HashPassword cannot be empty")
    @Column(name = "hash_password")
    private String HashPassword;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userinformation_id")
    private UserInformation userInformation;


    public UserCredentials( @NotBlank(message = "UserName cannot be empty") String userName,
            @NotBlank(message = "email cannot be empty") String email,
            @NotBlank(message = "HashPassword cannot be empty") String hashPassword) {
        this.userName = userName;
        this.email = email;
        HashPassword = hashPassword;
    }

    

    public UserCredentials() {
    }



    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }


    public String getEmail() {
        return email;
    }


    public String getHashPassword() {
        return HashPassword;
    }


    
}
