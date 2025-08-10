package com.example.ikandra.Controller;

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

import com.example.ikandra.Model.Payment;
import com.example.ikandra.Service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping()
    public List<Payment> getAll(){
        return paymentService.getAll();
    }

    @GetMapping("/{id}")
    public Payment getById(@PathVariable Long id){
        return paymentService.getById(id);
    }

    @PostMapping()
    public Payment create(@RequestBody Payment payment){
        return paymentService.create(payment);
    }

    @PutMapping()
    public Payment update(@RequestBody Payment payment){
        return paymentService.update(payment);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        paymentService.deleteById(id);
    }

    @DeleteMapping()
    public void deleteAll(){
        paymentService.deleteAll();
    }
}
