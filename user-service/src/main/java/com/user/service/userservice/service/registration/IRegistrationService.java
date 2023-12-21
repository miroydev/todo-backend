package com.user.service.userservice.service.registration;

import com.user.service.userservice.model.User.registration.PostRegistrateUserRequest;

public interface IRegistrationService {
    void createUser(PostRegistrateUserRequest request);
}
