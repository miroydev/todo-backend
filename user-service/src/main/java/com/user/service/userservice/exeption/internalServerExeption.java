package com.user.service.userservice.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class internalServerExeption extends RuntimeException {

    public internalServerExeption(Throwable cause) {
        super(cause);
    }
}
