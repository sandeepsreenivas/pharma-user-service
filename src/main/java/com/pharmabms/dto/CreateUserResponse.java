package com.pharmabms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CreateUserResponse {

    private String userId;
    private String firstName;
    private String lastName;
    private String shopName;
    private String shopAddress;
    private String mobileNumber;
    private String email;

}
