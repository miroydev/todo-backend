package com.user.service.userservice.service.registration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.service.userservice.entities.UserInformation;
import com.user.service.userservice.exeption.registrationExepcion;
import com.user.service.userservice.model.User.registration.PostRegistrateUserRequest;
import com.user.service.userservice.repository.UserRepository;

@Service
public class RegistrationService implements IRegistrationService{
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    

    public RegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }



    @Override
    public void createUser(PostRegistrateUserRequest registrationRequest) {

        if (existByEmail(registrationRequest.getEmail())){
            throw new registrationExepcion("This Email is already in use");
        }

        // Encrypt password
        String encodedPassword = passwordEncoder.encode(registrationRequest.getPassword());

        // Get Current Date
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateTime.format(dateTimeFormatter);


        UserInformation newUser = new UserInformation(
            registrationRequest.getUserName(),
            registrationRequest.getEmail(),
            encodedPassword,
            registrationRequest.getFullName(),
            registrationRequest.getBirthdate(),
            registrationRequest.getAddress(),
            registrationRequest.getGender(),
            formattedDate);

        userRepository.save(newUser);
    }


    @Override
    public Boolean existByEmail(String username) {
        return userRepository.existsByEmail(username);
    }
}
