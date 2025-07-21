package com.freelace.demo.Model;

import java.sql.Timestamp;
import java.util.List;

import com.freelace.demo.Enumeration.Enumeration.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@IdClass(OrderId.class)
@Table(name="orders")
public class Order {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User client;

    @Id
    @ManyToOne
    @JoinColumn(name="offer_id",referencedColumnName = "id", nullable = false)
    private Offer offer;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    @NotNull
    private Integer price;

    @Column(nullable = false, columnDefinition = "timestamp(6) with time zone")
    private Timestamp created_at;

    @Column(nullable = true, columnDefinition = "timestamp(6) with time zone")
    private Timestamp delivered_at;

    @Column(nullable = true, columnDefinition = "timestamp(6) with time zone")
    private Timestamp completed_at;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private List<Review> reviews;

    @OneToOne(mappedBy = "ordered")
    private Payement payment;
}

