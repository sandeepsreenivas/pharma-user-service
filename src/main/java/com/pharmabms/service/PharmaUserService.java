package com.pharmabms.service;

import com.pharmabms.dto.CreateUserRequest;
import com.pharmabms.dto.CreateUserResponse;

public interface PharmaUserService {

    CreateUserResponse createUser(CreateUserRequest request);
}
