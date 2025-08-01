package com.example.ikandra.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import com.example.ikandra.Enumeration.GlobalEnum.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double amount;

    @NotNull
    @Column(name = "send_at", nullable = false)
    private LocalDateTime send_at;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties({"offers", "notifications", "senderMessages", "receiverMessages", "senderTransactions", "receiverTransactions", "orders" })
    private User receiver_account;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties({"offers", "notifications", "senderMessages", "receiverMessages", "senderTransactions", "receiverTransactions", "orders" })
    private User sender_account;

    
}
