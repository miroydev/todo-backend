package com.user.service.userservice.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.service.userservice.entities.UserCredentials;
import com.user.service.userservice.entities.UserInformation;
import com.user.service.userservice.exeption.RegistrationExepcion;
import com.user.service.userservice.model.User.registration.PostRegistrateUserRequest;
import com.user.service.userservice.repository.CredentialsRepository;
import com.user.service.userservice.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class RegistrationService implements IRegistrationService{
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CredentialsRepository credentialsRepository;



    public RegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository,
            CredentialsRepository credentialsRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.credentialsRepository = credentialsRepository;
    }


    @Override
    @Transactional
    public void createUser(PostRegistrateUserRequest registrationRequest) {

        if (credentialsRepository.existsByEmail(registrationRequest.getEmail())){
            throw new RegistrationExepcion("This Email is already in use");
        }

        if (credentialsRepository.existsByUserName(registrationRequest.getUserName())){
            throw new RegistrationExepcion("This UserName is already in use");
        }

        UserInformation newUser = new UserInformation(
            registrationRequest.getFullName(),
            registrationRequest.getBirthdate(),
            registrationRequest.getAddress(),
            registrationRequest.getGender());

        // Encrypt password
        String encodedPassword = passwordEncoder.encode(registrationRequest.getPassword());

        UserCredentials userCredentials = new UserCredentials(
            registrationRequest.getUserName(),
            registrationRequest.getEmail(),
            encodedPassword
            );

        newUser.setCredentials(userCredentials);
        userCredentials.setUserInformation(newUser);
        
        
        
        //Asociate credentials
        userRepository.save(newUser);
    }
}
