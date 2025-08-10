package com.example.ikandra.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq")
    private Long id;

    @NotNull
    @Column(name = "rating", nullable = false)
    private Integer rating;

    @NotNull
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "offer_id", referencedColumnName = "offer_id"),
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    })
    @JsonIgnoreProperties({"reviews", "payment"})
    private Order order;

    
}
