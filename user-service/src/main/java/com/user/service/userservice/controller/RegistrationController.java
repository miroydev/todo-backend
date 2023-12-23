package com.user.service.userservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.userservice.exeption.RegistrationExepcion;
import com.user.service.userservice.model.User.registration.PostRegistrateUserRequest;
import com.user.service.userservice.service.registration.IRegistrationService;

@RestController
public class RegistrationController {

    @Autowired
    private IRegistrationService registrationService;
    

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody PostRegistrateUserRequest registrateUserRequest){
        
        try {
            registrationService.createUser(registrateUserRequest);
            return new ResponseEntity<>("User Created Successfully", HttpStatus.CREATED);

        }catch (RegistrationExepcion e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        
        }catch (Exception e) {
            return new ResponseEntity<>("Problem solving request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
