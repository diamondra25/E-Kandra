package com.example.ikandra.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import com.example.ikandra.Enumeration.GlobalEnum.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@Entity
@Table(name = "payement", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "offer_id"})
})
public class Payment {

    @Id
    private Long id;

    @NotNull
    @Column(name = "amount", nullable = false)
    private Double amount;

    @NotNull
    @Column(name = "paid_at", nullable = false)
    private LocalDateTime paid_at;

    @NotNull
    @Size(max = 255)
    @Column(name = "payment_method", nullable = false, length = 255)
    private String payment_method;

    @NotNull
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "offer_id", referencedColumnName = "offer_id"),
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    })
    @JsonIgnoreProperties({"payment", "reviews"})
    private Order order;
}
