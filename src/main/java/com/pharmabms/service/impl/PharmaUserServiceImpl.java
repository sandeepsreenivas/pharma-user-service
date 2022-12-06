package com.pharmabms.service.impl;

import com.pharmabms.dto.CreateUserRequest;
import com.pharmabms.dto.CreateUserResponse;
import com.pharmabms.entity.PharmaUser;
import com.pharmabms.exceptions.EmailExistsException;
import com.pharmabms.exceptions.MobileNumberExistsException;
import com.pharmabms.repository.PharmaUserRepository;
import com.pharmabms.service.PharmaUserIdService;
import com.pharmabms.service.PharmaUserService;
import com.pharmabms.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class PharmaUserServiceImpl implements PharmaUserService {

    @Autowired
    private PharmaUserRepository pharmaUserRepository;

    @Autowired
    private PharmaUserIdService pharmaUserIdService;

    @Override
    public CreateUserResponse createUser(CreateUserRequest request)
            throws MobileNumberExistsException, EmailExistsException {
        if (isMobileNumberExists(request.getMobileNumber())) {
            throw new MobileNumberExistsException("Mobile number already exists !!");
        }
        if (isEmailExists(request.getEmail())) {
            throw new EmailExistsException("Email already exists !!");
        }
        Integer currentUserId = pharmaUserIdService.getCurrentUserId() + 1;
        String userId = Constants.USER_ID_PREFIX + currentUserId;
        PharmaUser pharmaUser = new PharmaUser(userId, request.getFirstName(),
                request.getLastName(), request.getShopName(), request.getShopAddress(),
                request.getMobileNumber(), request.getEmail(), request.getPassword(),
                LocalDateTime.now(), LocalDateTime.now());
        pharmaUserRepository.save(pharmaUser);
        pharmaUserIdService.updateCurrentUserId(currentUserId);
        return new CreateUserResponse(userId, request.getFirstName(),
                request.getLastName(), request.getShopName(),
                request.getShopAddress(), request.getMobileNumber(), request.getEmail());
    }

    @Override
    public boolean isMobileNumberExists(String mobileNumber) {
        PharmaUser pharmaUser = pharmaUserRepository.findPharmaUserByMobileNumber(mobileNumber);
        return pharmaUser != null && pharmaUser.getMobileNumber().equals(mobileNumber);
    }

    @Override
    public boolean isEmailExists(String email) {
        PharmaUser pharmaUser = pharmaUserRepository.findPharmaUserByEmail(email);
        return pharmaUser != null && pharmaUser.getEmail().equals(email);
    }

}
