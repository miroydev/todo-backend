package com.user.service.userservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.userservice.model.User.registration.PostRegistrateUserRequest;
import com.user.service.userservice.model.User.registration.PostRegistrateUserResponse;
import com.user.service.userservice.service.registration.IRegistrationService;

@RestController
public class RegistrationController {

    @Autowired
    private IRegistrationService registrationService;
    

    @PostMapping("/register")
    public PostRegistrateUserResponse register(@RequestBody PostRegistrateUserRequest registrateUserRequest){
        
        return registrationService.createUser(registrateUserRequest);
    }
}
