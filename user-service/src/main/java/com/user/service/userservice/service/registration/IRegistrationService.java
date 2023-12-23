package com.user.service.userservice.service.registration;

import com.user.service.userservice.model.User.registration.PostRegistrateUserRequest;
import com.user.service.userservice.model.User.registration.PostRegistrateUserResponse;

public interface IRegistrationService {
    PostRegistrateUserResponse createUser(PostRegistrateUserRequest request);
}
