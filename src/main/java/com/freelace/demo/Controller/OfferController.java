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

import com.freelace.demo.Model.Offer;
import com.freelace.demo.Service.OfferService;

@RestController
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @GetMapping()
    public List<Offer> getAll() {
        return offerService.getAll();
    }

    @GetMapping("/{id}")
    public Offer getById(@PathVariable Long id) {
        return offerService.getById(id);
    }

    @PostMapping
    public Offer create(@RequestBody Offer offer) {
        return offerService.create(offer);
    }

    @PutMapping("/{id}")
    public Offer update(@PathVariable Long id,@RequestBody Offer offerDetails) {
        return offerService.update(offerDetails);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Offer offer = offerService.getById(id);
        if (offer != null) {
            offerService.delete(offer);
        }
    }

    @DeleteMapping()
    public void deleteAll() {
        offerService.deleteAll();
    }

}
