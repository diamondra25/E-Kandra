package com.example.ikandra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ikandra.Model.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long>{
    
}
