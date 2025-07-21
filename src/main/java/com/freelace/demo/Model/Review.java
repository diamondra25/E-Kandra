package com.freelace.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
    private @Id @GeneratedValue Long id;

    @Column(nullable = false)
    private Integer rating;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false),
        @JoinColumn(name = "offer_id", referencedColumnName = "offer_id", nullable = false)
    })
    private Order order;

}