package com.example.ikandra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ikandra.Model.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long>{
    
}
