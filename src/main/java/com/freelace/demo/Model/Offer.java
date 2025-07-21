package com.freelace.demo.Model;

import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="offer")
public class Offer {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(length = 255, nullable = false)
    private String designation;

    @Column(nullable = false)
    private Double base_price;

    @Column(nullable = false)
    private Integer delivery_time_days;

    @Column(nullable = false, columnDefinition = "timestamp(6) with time zone")
    private Timestamp created_at;

    private Boolean is_active;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User freelancer; 
    
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Offer_image> images;

    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;

}
