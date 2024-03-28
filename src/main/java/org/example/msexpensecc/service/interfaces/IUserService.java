package org.example.msexpensecc.service.interfaces;

import org.example.msexpensecc.controller.requests.CreateUserRequest;
import org.example.msexpensecc.controller.requests.ValidateUserRequest;
import org.example.msexpensecc.controller.responses.BaseResponse;
import org.example.msexpensecc.entity.User;

public interface IUserService {
    BaseResponse get(String request);

    User findOneAndEnsureExist(String id);

    BaseResponse create(CreateUserRequest request);

    BaseResponse login(ValidateUserRequest request);
}
