package com.user.service.userservice.service.Account;

import com.user.service.userservice.model.User.Account.GetAccountInformationRequest;
import com.user.service.userservice.model.User.Account.GetAccountInformationResponse;

public interface IAccountService {

    GetAccountInformationResponse getInfoAccount(GetAccountInformationRequest accounInformation);
}
