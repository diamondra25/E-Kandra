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

import com.freelace.demo.Model.Payement;
import com.freelace.demo.Service.PayementService;

@RestController
@RequestMapping("/payments")
public class PayementController {
    @Autowired
    private PayementService payementService;

    @GetMapping()
    public List<Payement> getAll(){
        return payementService.getAll();
    }
    
    @GetMapping("/{id}")
    public Payement getById(@PathVariable Long id) {
        return payementService.getById(id);
    }

    @PostMapping
    public Payement create(@RequestBody Payement payement) {
        return payementService.create(payement);
    }

    @PutMapping("/{id}")
    public Payement update(@PathVariable Long id,@RequestBody Payement payementDetails) {
        return payementService.update(id, payementDetails);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        payementService.delete(id);
    }

    @DeleteMapping()
    public void deleteAll() {
        payementService.deleteAll();
    }
    
}
