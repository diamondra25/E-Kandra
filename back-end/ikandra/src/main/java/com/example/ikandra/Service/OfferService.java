package com.example.ikandra.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ikandra.Model.Offer;
import com.example.ikandra.Repository.OfferRepositry;

@Service
public class OfferService {
    @Autowired
    OfferRepositry offerRepo;

    public List<Offer> getAll(){
        return offerRepo.findAll();
    }

    public Offer getById(Long id){
        return offerRepo.findById(id).orElse(null);
    }

    public Offer create (Offer offer){
        return offerRepo.save(offer);
    }

    public Offer update(Offer offer){
        Offer new_offer= offerRepo.findById(offer.getId()).orElse(null);
        return offerRepo.save(new_offer);
    }

    public void deleteById(Long id){
        offerRepo.deleteById(id);
    }

    public void deleteAll(){
        offerRepo.deleteAll();
    }

    public List<Offer> findByFreelancer_Id(Long id){
        return offerRepo.findByFreelancer_Id(id);
    }

    public List<Offer> findByCategory_Id(Long id){
        return offerRepo.findByCategory_Id(id);
    }
}
