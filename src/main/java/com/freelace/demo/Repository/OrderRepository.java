package com.freelace.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.freelace.demo.Model.Order;
import com.freelace.demo.Model.OrderId;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
     Optional<Order> findByClient_IdAndOffer_Id(Long clientId, Long offerId);
}
