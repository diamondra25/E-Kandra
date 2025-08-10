package com.example.ikandra.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ikandra.Model.Offer_image;

public interface Offer_imageRepository extends JpaRepository<Offer_image, Long> {
    List<Offer_image> findByOffer_Id(Long id);

}
