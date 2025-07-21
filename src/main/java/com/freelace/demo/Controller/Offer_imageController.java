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

import com.freelace.demo.Model.Offer_image;
import com.freelace.demo.Service.Offer_imageService;

@RestController
@RequestMapping("/offer_images")
public class Offer_imageController {
    @Autowired
    private Offer_imageService offer_imageService;

    @GetMapping()
    public List<Offer_image> getAll() {
        return offer_imageService.getAll();
    }

    @GetMapping("/{id}")
    public Offer_image getById(@PathVariable Long id) {
        return offer_imageService.getById(id);
    }

    @PostMapping
    public Offer_image create(@RequestBody Offer_image offer_image) {
        return offer_imageService.create(offer_image);
    }

    @PutMapping("/{id}")
    public Offer_image update(@PathVariable Long id,@RequestBody Offer_image offer_imageDetails) {
        return offer_imageService.update(id, offer_imageDetails);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        offer_imageService.deleteById(id);
    }

    @DeleteMapping()
    public void deleteAll() {
        offer_imageService.deleteAll();
    }
    
    
}
