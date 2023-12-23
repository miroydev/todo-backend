package com.user.service.userservice.model.User.registration;

public class PostRegistrateUserResponse {

    private Boolean userCreated;
    private String message;
    private int ErrorCode;

    
    

    public PostRegistrateUserResponse() {
    }
    
    public PostRegistrateUserResponse(Boolean userCreated, String message, int errorCode) {
        this.userCreated = userCreated;
        this.message = message;
        ErrorCode = errorCode;
    }
    public Boolean getUserCreated() {
        return userCreated;
    }
    public String getMessage() {
        return message;
    }
    public int getErrorCode() {
        return ErrorCode;
    }
    public void setUserCreated(Boolean userCreated) {
        this.userCreated = userCreated;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setErrorCode(int errorCode) {
        ErrorCode = errorCode;
    }


    
}
