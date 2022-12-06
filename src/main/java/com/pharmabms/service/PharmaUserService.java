package com.pharmabms.service;

import com.pharmabms.dto.CreateUserRequest;
import com.pharmabms.dto.CreateUserResponse;
import com.pharmabms.exceptions.EmailExistsException;
import com.pharmabms.exceptions.MobileNumberExistsException;

public interface PharmaUserService {
    CreateUserResponse createUser(CreateUserRequest request)
            throws MobileNumberExistsException, EmailExistsException;
    boolean isMobileNumberExists(String mobileNumber);
    boolean isEmailExists(String email);
}
