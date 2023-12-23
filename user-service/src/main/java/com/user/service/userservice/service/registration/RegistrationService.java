package com.user.service.userservice.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.service.userservice.entities.UserCredentials;
import com.user.service.userservice.entities.UserInformation;
import com.user.service.userservice.model.User.registration.PostRegistrateUserRequest;
import com.user.service.userservice.model.User.registration.PostRegistrateUserResponse;
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
    public PostRegistrateUserResponse createUser(PostRegistrateUserRequest registrationRequest) {
        
        PostRegistrateUserResponse resp = new PostRegistrateUserResponse();

        try{

            if (credentialsRepository.existsByEmail(registrationRequest.registrationInfo.getEmail()))
            {
                resp.setUserCreated(true);
                resp.setMessage("Email alredy exist");
                resp.setErrorCode(1);
                return resp;
            }


            UserInformation newUser = new UserInformation(
            registrationRequest.registrationInfo.getFullName(),
            registrationRequest.registrationInfo.getBirthdate(),
            registrationRequest.registrationInfo.getAddress(),
            registrationRequest.registrationInfo.getGender());
            
            // Encrypt password
            String encodedPassword = passwordEncoder.encode(registrationRequest.registrationInfo.getPassword());

            UserCredentials userCredentials = new UserCredentials(
                registrationRequest.registrationInfo.getUserName(),
                registrationRequest.registrationInfo.getEmail(),
                encodedPassword
                );

            newUser.setCredentials(userCredentials);
            userCredentials.setUserInformation(newUser);
        
            //Asociate credentials
            userRepository.save(newUser);

        }catch (Exception e) {
            return new PostRegistrateUserResponse(false, e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        resp.setUserCreated(true);
        resp.setMessage("User Created");
        resp.setErrorCode(0);
        return resp;

        
    }
}
