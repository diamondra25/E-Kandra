package com.freelace.demo.Model;


import java.sql.Timestamp;

import com.freelace.demo.Enumeration.Enumeration.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payement")
public class Payement {
    private @Id @GeneratedValue Long id;

    @Column(length = 255, nullable = false)
    private String payment_method;

    @Column( nullable = false)
    private Double amount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false, columnDefinition = "timestamp(6) with time zone")
    private Timestamp paid_at;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
        @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false),
        @JoinColumn(name = "offer_id", referencedColumnName = "offer_id", nullable = false)
    })
    private Order ordered; 

}
