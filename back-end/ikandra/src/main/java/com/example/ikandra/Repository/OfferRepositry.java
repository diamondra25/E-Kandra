package com.example.ikandra.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ikandra.Model.Offer;

public interface OfferRepositry extends JpaRepository<Offer,Long> {
    List<Offer> findByFreelancer_Id(Long id);
    List<Offer> findByCategory_Id(Long id);
    
}
