package com.user.service.userservice.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegistrationExepcion extends RuntimeException{
    public RegistrationExepcion(String cause) {
        super(cause);
    }
}
