package com.example.ikandra.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ikandra.Model.Offer;
import com.example.ikandra.Service.OfferService;

@RestController
@RequestMapping("offers")
public class OfferController {
    @Autowired
    OfferService offerService;

    @GetMapping()
    public List<Offer> getAll(){
        return offerService.getAll();
    }

    @GetMapping("/getByFreelancer_Id")
    public List<Offer> getByFreelancer_Id(@RequestParam("id") Long id){
        return offerService.findByFreelancer_Id(id);
    }

    @GetMapping("/getByCategory_Id")
    public List<Offer> getByCategory_Id(@RequestParam("id") Long id){
        return offerService.findByCategory_Id(id);
    }

    @GetMapping("/{id}")
    public Offer getById(@PathVariable("id") Long id){
        return offerService.getById(id);
    }

    @PostMapping()
    public Offer create (Offer offer){
        return offerService.create(offer);
    }

    @PutMapping 
    public Offer update(Offer offer){
        return offerService.update(offer);
    }

    @DeleteMapping("/{id}")
    public void deleteById(Long id){
         offerService.deleteById(id);
    }

    @DeleteMapping()
    public void deleteAll(){
        offerService.deleteAll();
    }
}
