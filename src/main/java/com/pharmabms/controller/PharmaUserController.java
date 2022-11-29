package com.pharmabms.controller;

import com.pharmabms.dto.CreateUserRequest;
import com.pharmabms.dto.CreateUserResponse;
import com.pharmabms.service.PharmaUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pharmabms/user")
@Slf4j
public class PharmaUserController {

    @Autowired
    private PharmaUserService pharmaUserService;

    @PostMapping("/register")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
        CreateUserResponse response = new CreateUserResponse();
        try {
            response = pharmaUserService.createUser(request);
        } catch (Exception e) {
            log.error("Error while registering user : {}", request, e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
