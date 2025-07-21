package com.freelace.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freelace.demo.Model.Offer;

public interface OfferRepository  extends JpaRepository<Offer, Long> {

}
