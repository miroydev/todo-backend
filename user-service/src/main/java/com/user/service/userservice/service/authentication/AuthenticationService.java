package com.user.service.userservice.service.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.service.userservice.model.User.authentication.PostAuthenticationRequest;
import com.user.service.userservice.model.User.authentication.PostAuthenticationResponse;
import com.user.service.userservice.repository.CredentialsRepository;
import jakarta.transaction.Transactional;


@Service
public class AuthenticationService implements IAuthenticationService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CredentialsRepository credentialsRepository;

    public AuthenticationService(PasswordEncoder passwordEncoder,
            CredentialsRepository credentialsRepository) {
        this.passwordEncoder = passwordEncoder;
        this.credentialsRepository = credentialsRepository;
    }


    @Override
    @Transactional
    public PostAuthenticationResponse authenticateUser(PostAuthenticationRequest authenticationInfo){

        PostAuthenticationResponse res = new PostAuthenticationResponse();

        try{
            
            String email = authenticationInfo.getAuthenticationInfo().getEmail();

            if (!credentialsRepository.existsByEmail(email)){
                res.setUserAuthenticated(true);
                res.setMessage("User does not exist");
                res.setErrorCode(1);
                return res;
            }

            if (!passwordEncoder.matches(authenticationInfo.getAuthenticationInfo().getPassword(), credentialsRepository.getHashPassword(email))){
                res.setUserAuthenticated(false);
                res.setMessage("Wrong Password");
                res.setErrorCode(2);
                return res;
            }
            
            res.setUserAuthenticated(true);
            res.setMessage("User Authenticated Sussesfully");
            res.setErrorCode(0);

        }catch (Exception e) {
            return new PostAuthenticationResponse(false, e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return res;
    }


}
