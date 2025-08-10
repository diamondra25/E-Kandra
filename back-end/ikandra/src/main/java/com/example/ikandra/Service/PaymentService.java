package com.example.ikandra.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ikandra.Model.Payment;
import com.example.ikandra.Repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAll(){
        return paymentRepository.findAll();
    }

    public Payment getById(Long id){
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment create(Payment payment){
        return paymentRepository.save(payment);
    }

    public Payment update(Payment payment){
        Payment existPayment=paymentRepository.findById(payment.getId()).orElse(null);
        if(existPayment!=null){
            return paymentRepository.save(existPayment);
        }
        return null;
    }

    public void deleteById(Long id){
        paymentRepository.deleteById(id);
    }

    public void deleteAll(){
        paymentRepository.deleteAll();
    }
}
