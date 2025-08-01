package com.example.ikandra.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "offer_image")
public class Offer_image {

    @Id
    private Long id;

    @Size(max = 255)
    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(
        name = "offer_id",
        referencedColumnName = "id",
        nullable = false
    )
    @JsonIgnoreProperties({"orders", "images"})
    private Offer offer;

}
