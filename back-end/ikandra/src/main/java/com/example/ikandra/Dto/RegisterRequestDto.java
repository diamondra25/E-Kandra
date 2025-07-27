package com.example.ikandra.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {
    private String nom_user;
    private String prenom;
    private String pseudo;
    private String email;
    private String role ;
    private String password ;
    private String bio;
    private String phone;
    private Double solde;
    private String designation;
    private String designation2;
    private String designation3;  
    private Boolean is_active=false;

}

