package com.example.ikandra.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

import com.example.ikandra.Enumeration.GlobalEnum.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@IdClass(OrderId.class)
@Table(name="orders")
public class Order {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties({"offers", "notifications", "senderMessages", "receiverMessages", "senderTransactions", "receiverTransactions", "orders" })
    private User client;

    @Id
    @ManyToOne
    @JoinColumn(name="offer_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties({"orders"})
    private Offer offer;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    @NotNull
    private Integer price;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = true)
    private LocalDateTime delivered_at;

    @Column(nullable = true)
    private LocalDateTime completed_at;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private List<Review> reviews;

    @OneToOne(mappedBy = "order")
    private Payment payment;
}

