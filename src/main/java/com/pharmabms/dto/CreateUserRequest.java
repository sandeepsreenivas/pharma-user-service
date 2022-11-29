package com.pharmabms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CreateUserRequest {

    private String firstName;
    private String lastName;
    private String shopName;
    private String shopAddress;
    private String mobileNumber;
    private String email;
    private String password;

}
