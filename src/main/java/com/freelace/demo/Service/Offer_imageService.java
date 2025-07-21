package com.freelace.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelace.demo.Model.Offer_image;
import com.freelace.demo.Repository.Offer_imageRepository;

@Service
public class Offer_imageService {
    @Autowired
    private Offer_imageRepository offer_imageRepository;

    public List<Offer_image> getAll() {
        return offer_imageRepository.findAll();
    }

    public Offer_image getById(Long id) {
        return offer_imageRepository.findById(id).orElse(null);
    }

    public Offer_image create(Offer_image offer_image) {
        return offer_imageRepository.save(offer_image);
    }

    public Offer_image update(Long id, Offer_image offer_imageDetails) {
        Offer_image offer_image = getById(id);
        if (offer_image != null) {
            offer_image.setImage_url(offer_imageDetails.getImage_url());
            offer_image.setOffer(offer_imageDetails.getOffer());
            return offer_imageRepository.save(offer_image);
        }
        return null;
    }
    public void deleteById(Long id) {
        offer_imageRepository.deleteById(id);
    }

    public void deleteAll() {
        offer_imageRepository.deleteAll();
    }


}
