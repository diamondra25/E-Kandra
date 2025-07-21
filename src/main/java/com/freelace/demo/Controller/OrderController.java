package com.freelace.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelace.demo.Model.Order;
import com.freelace.demo.Service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @GetMapping()
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{user_id}/{offer_id}")
    public Order getById(@PathVariable Long user_id,@PathVariable Long offer_id) {
        return orderService.getById(user_id, offer_id);
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @PutMapping("/{user_id}/{offer_id}")
    public Order update(@PathVariable Long user_id,@PathVariable Long offer_id, @RequestBody Order orderDetails)
    {
        return orderService.update(user_id, offer_id, orderDetails);
    }

    @DeleteMapping("/{user_id}/{offer_id}")
    public void delete(@PathVariable Long user_id,@PathVariable Long offer_id) {
        orderService.delete(user_id, offer_id);
    }

    @DeleteMapping()
    public void deleteAll() {
        orderService.deleteAll();
    }
}
