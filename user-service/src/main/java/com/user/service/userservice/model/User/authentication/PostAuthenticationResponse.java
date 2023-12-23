package com.user.service.userservice.model.User.authentication;

public class PostAuthenticationResponse {
    private Boolean userAuthenticated;
    private String message;
    private int ErrorCode;


    


    public PostAuthenticationResponse(Boolean userAuthenticated, String message, int errorCode) {
        this.userAuthenticated = userAuthenticated;
        this.message = message;
        ErrorCode = errorCode;
    }

    
    public PostAuthenticationResponse() {
    }

    public Boolean getUserAuthenticated() {
        return userAuthenticated;
    }
    public String getMessage() {
        return message;
    }
    public int getErrorCode() {
        return ErrorCode;
    }


    public void setUserAuthenticated(Boolean userAuthenticated) {
        this.userAuthenticated = userAuthenticated;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public void setErrorCode(int errorCode) {
        ErrorCode = errorCode;
    }

    
    
    
}
