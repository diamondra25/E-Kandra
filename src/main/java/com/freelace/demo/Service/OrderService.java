package com.freelace.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.freelace.demo.Model.Order;
import com.freelace.demo.Repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(Long clientId, Long offerId) {
        return orderRepository.findByClient_IdAndOffer_Id(clientId, offerId)
                .orElse(null);
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public Order update(Long user_id, Long offer_id, Order orderDetails) {
        Order order = getById(user_id, offer_id);
        if (order != null) {
            order.setStatus(orderDetails.getStatus());
            order.setPrice(orderDetails.getPrice());
            order.setDelivered_at(orderDetails.getDelivered_at());
            order.setCompleted_at(orderDetails.getCompleted_at());
            return orderRepository.save(order);
        }
        return null;
    }

    public void delete(Long user_id, Long offer_id) {
        Order order = getById(user_id, offer_id);
        if (order != null) {
            orderRepository.delete(order);
        }
    }

    public void deleteAll() {
        orderRepository.deleteAll();
    }
}
