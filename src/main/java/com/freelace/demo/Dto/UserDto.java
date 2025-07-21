package com.freelace.demo.Dto;

import org.springframework.web.multipart.MultipartFile;

import com.freelace.demo.Enumeration.UserEnum.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String nom_user;
    private MultipartFile photo;
    private String pseudo;
    private String email;
    private UserType role;
    private String password ;
    private String bio;
    private String phone;
    private Boolean is_active;
}
