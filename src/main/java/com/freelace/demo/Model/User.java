package com.freelace.demo.Model;

import com.freelace.demo.Enumeration.UserEnum.UserType;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id 
    @GeneratedValue
    private Integer id;

    @Column(length = 255, nullable = false)
    private String nom_user;

    @Column(length = 255, nullable = true)
    private String prenom;

    @Column(length = 255, nullable = true)
    private String photo_url;

    @Column(length = 255, nullable = false, unique = true)
    @NotNull
    private String pseudo;

    @Column(length = 255, nullable = false, unique = true)
    @NotNull
    private String email;

    @Column(length = 255, nullable = false)
    private UserType role ;

    @Column(length = 255, nullable = false)
    @NotNull
    private String password ;

    @Column(length = 255, nullable = true)
    private String bio;

    @Column(length = 255, nullable = false, unique = true)
    @NotNull
    private String phone;
    
    private Boolean is_active;

    @OneToMany(mappedBy = "freelancer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Offer> offers;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> senderMessages;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> receiverMessages;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;

    
}




