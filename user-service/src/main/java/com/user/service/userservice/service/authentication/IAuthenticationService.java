package com.user.service.userservice.service.authentication;

import com.user.service.userservice.model.User.authentication.PostAuthenticationRequest;
import com.user.service.userservice.model.User.authentication.PostAuthenticationResponse;

public interface IAuthenticationService {
    PostAuthenticationResponse authenticateUser(PostAuthenticationRequest authenticationInfo); 
}
