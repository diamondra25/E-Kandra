package com.example.ikandra.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ikandra.Model.Order;
import com.example.ikandra.Repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepo;

    public Order getById(Long user_id, Long offer_id) {
        return orderRepo.findByClient_IdAndOffer_Id(user_id, offer_id)
                            .orElse(null);
    }

}
