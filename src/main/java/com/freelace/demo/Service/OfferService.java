package com.freelace.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelace.demo.Model.Offer;
import com.freelace.demo.Repository.OfferRepository;

@Service
public class OfferService {
    @Autowired
    private OfferRepository offerRepository;

    public List<Offer> getAll(){
        return offerRepository.findAll();
    }

    public Offer getById(Long id){
        return offerRepository.findById(id).orElse(null);
    }

    public Offer create (Offer offer){
        return offerRepository.save(offer);
    }

    public Offer update (Offer offer){
       Offer existingOffer = offerRepository.findById(offer.getId()).orElse(null);
       if (existingOffer != null) {
            existingOffer.setTitle(offer.getTitle());
            existingOffer.setDesignation(offer.getDesignation());
            existingOffer.setBase_price(offer.getBase_price());
            existingOffer.setDelivery_time_days(offer.getDelivery_time_days());
            existingOffer.setCreated_at(offer.getCreated_at());
            existingOffer.setIs_active(offer.getIs_active());
            existingOffer.setFreelancer(offer.getFreelancer());
            existingOffer.setCategory(offer.getCategory());
            existingOffer.setImages(offer.getImages());
            existingOffer.setOrders(offer.getOrders());
           return offerRepository.save(existingOffer);
       }
       return null;
    }

    public void delete(Offer offer) {
        offerRepository.delete(offer);
    }

    public void deleteAll() {
        offerRepository.deleteAll();
    }
}
