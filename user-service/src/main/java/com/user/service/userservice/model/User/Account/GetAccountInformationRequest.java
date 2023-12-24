package com.user.service.userservice.model.User.Account;

public class GetAccountInformationRequest {

    private  String userName;

    

    public GetAccountInformationRequest() {
    }



    public GetAccountInformationRequest(String userName) {
        this.userName = userName;
    }



    public String getUserName() {
        return userName;
    }



    public void setUserName(String userName) {
        this.userName = userName;
    }

}
