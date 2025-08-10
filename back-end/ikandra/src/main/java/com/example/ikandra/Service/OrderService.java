package com.example.ikandra.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ikandra.Model.Order;
import com.example.ikandra.Repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepo;

    public List<Order> getAll(){
        return orderRepo.findAll();
    }

    public Order getById(Long user_id, Long offer_id) {
        return orderRepo.findByClient_IdAndOffer_Id(user_id, offer_id)
                            .orElse(null);
    }

    public Order create(Order order){
        return orderRepo.save(order);
    }
    
    public Order update(Order order){
        Order existOrder= orderRepo.findByClient_IdAndOffer_Id(order.getClient().getId(), order.getOffer().getId()).orElse(null);
        if(existOrder!=null){
            return orderRepo.save(existOrder);
        }
        return null;
    }

    public void deleteById(Long user_id, Long offer_id){
        orderRepo.deleteByClient_IdAndOffer_Id(user_id, offer_id);
    }

    public void deleteAll(){
        orderRepo.deleteAll();
    }
}
