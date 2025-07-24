package com.freelace.demo.Dto;

import com.freelace.demo.Enumeration.UserEnum.UserType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String email;
    private String password;
    private UserType role;

}
