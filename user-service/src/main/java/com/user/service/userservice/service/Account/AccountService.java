package com.user.service.userservice.service.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.userservice.entities.UserInformation;
import com.user.service.userservice.model.User.Account.AccountModel;
import com.user.service.userservice.model.User.Account.GetAccountInformationRequest;
import com.user.service.userservice.model.User.Account.GetAccountInformationResponse;
import com.user.service.userservice.repository.CredentialsRepository;
import com.user.service.userservice.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountService implements IAccountService {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private CredentialsRepository credentialsRepository;

    
    


    public AccountService(UserRepository userRepository, CredentialsRepository credentialsRepository) {
        this.userRepository = userRepository;
        this.credentialsRepository = credentialsRepository;
    }





    @Override
    @Transactional
    public GetAccountInformationResponse getInfoAccount(GetAccountInformationRequest accounInformation){
        GetAccountInformationResponse resp = new GetAccountInformationResponse();
        AccountModel accountModel = new AccountModel();
        

        try{
            int userIndormationId = credentialsRepository.getUserInformationId(accounInformation.getUserName());
            System.out.println("SIUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
            System.out.println(userIndormationId);
            UserInformation userInformation = userRepository.findById(userIndormationId).orElse(null);
            System.out.println("SIUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
            if (userInformation != null){
                accountModel.setUsername(accounInformation.getUserName());
                accountModel.setFullName(userInformation.getFullName());
                accountModel.setGender(userInformation.getGender());
                accountModel.setBirthdate(userInformation.getBirthdate());
                accountModel.setAddress(userInformation.getAddress());
                resp.setAccountInformation(accountModel);
                return resp;
            }
        }catch (Exception e) {
            return resp;
        }
        
        return resp;
    }
}
