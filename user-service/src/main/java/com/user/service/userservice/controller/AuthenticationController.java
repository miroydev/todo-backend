package com.user.service.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.userservice.model.User.authentication.PostAuthenticationRequest;
import com.user.service.userservice.model.User.authentication.PostAuthenticationResponse;
import com.user.service.userservice.service.authentication.IAuthenticationService;

@RestController
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public PostAuthenticationResponse register(@RequestBody PostAuthenticationRequest authenticationRequest){
        return authenticationService.authenticateUser(authenticationRequest);
    }
}
