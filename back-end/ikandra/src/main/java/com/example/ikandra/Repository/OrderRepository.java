package com.example.ikandra.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ikandra.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    Optional<Order> findByClient_IdAndOffer_Id(Long userId, Long offerId);

}
