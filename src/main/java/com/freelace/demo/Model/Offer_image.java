package com.freelace.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="offer_image")
public class Offer_image {
    private @Id @GeneratedValue Long id;

    @Column(length = 255, nullable = false)
    private String image_url;

    @ManyToOne
    @JoinColumn(name = "offer_id", referencedColumnName = "id", nullable = false)
    private Offer offer;
}
