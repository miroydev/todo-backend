package com.user.service.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.userservice.model.User.Account.GetAccountInformationRequest;
import com.user.service.userservice.model.User.Account.GetAccountInformationResponse;
import com.user.service.userservice.service.Account.IAccountService;

@RestController
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("/account")
    public GetAccountInformationResponse getInfoAccount(GetAccountInformationRequest accounInformation){
        return accountService.getInfoAccount(accounInformation);
    }
    
}
