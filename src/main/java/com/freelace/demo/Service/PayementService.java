package com.freelace.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelace.demo.Model.Payement;
import com.freelace.demo.Repository.PayementRepository;

@Service
public class PayementService {
    @Autowired
    private PayementRepository payementRepository;

    public List<Payement> getAll() {
        return payementRepository.findAll();
    }

    public Payement getById(Long id) {
        return payementRepository.findById(id).orElse(null);
    }
    public Payement create(Payement payement) {
        return payementRepository.save(payement);
    }

    public Payement update(Long id, Payement payementDetails) {
        Payement payement = getById(id);
        if (payement != null) {
            payement.setAmount(payementDetails.getAmount());
            payement.setOrdered(payementDetails.getOrdered());
            return payementRepository.save(payement);
        }
        return null;
    }

    public void delete(Long id) {
        payementRepository.deleteById(id);
    }

    public void deleteAll() {
        payementRepository.deleteAll();
    }
}
