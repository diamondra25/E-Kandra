package com.example.ikandra.Service;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Transaction;
import org.springframework.stereotype.Service;

import com.example.ikandra.Model.User;
// import com.example.ikandra.Repository.TransactionRepository;
import com.example.ikandra.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionService {

    // @Autowired
    // private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void effectuerTransaction(Long senderId, Long receiverId, Double montant) {
        User sender = userRepository.findById(senderId).orElseThrow();
        User receiver = userRepository.findById(receiverId).orElseThrow();

        if (sender.getSolde() < montant) {
            throw new RuntimeException("Solde insuffisant");
        }

        sender.setSolde(sender.getSolde() - montant);
        receiver.setSolde(receiver.getSolde() + montant);

        userRepository.save(sender);
        userRepository.save(receiver);

        // Transaction transaction = new Transaction();


        // transactionRepository.save(transaction);
    }
}
