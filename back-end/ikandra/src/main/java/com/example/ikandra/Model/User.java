package com.example.ikandra.Model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.ikandra.Enumeration.UserEnum.UserType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "users_id_seq", allocationSize = 1)
    private Long id;

    @Column(length = 255, nullable = false)
    private String nom_user;

    @Column(length = 255, nullable = true)
    private String prenom;

    @Column(length = 255, nullable = true)
    private String photo_url;

    @Column(length = 255, nullable = true)
    private String cin_recto_url;

    @Column(length = 255, nullable = true)
    private String cin_verso_url;

    @Column(length = 255, nullable = false, unique = true)
    private String pseudo;

    @Column(length = 255, nullable = false, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private UserType role ;

    @Column(length = 255, nullable = false)
    private String password ;

    @Column(length = 255, nullable = true)
    private String bio;

    @Column(length = 255, nullable = false, unique = true)
    private String phone;

    @Column(nullable = true)
    private Double solde;
    
    @Column(nullable = false)
    private Boolean is_active=false;

    @OneToMany(mappedBy = "freelancer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Offer> offers;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> senderMessages;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> receiverMessages;

    @OneToMany(mappedBy = "sender_account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transactions> senderTransactions;

    @OneToMany(mappedBy = "receiver_account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transactions> receiverTransactions;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(); 
    }

    @Override
    public String getUsername() {
        return this.email; 
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return this.is_active; }
}