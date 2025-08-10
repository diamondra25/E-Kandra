package com.example.ikandra.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ikandra.Context.FileUploadUtil;
import com.example.ikandra.Model.Offer;
import com.example.ikandra.Model.Offer_image;
import com.example.ikandra.Repository.OfferRepositry;
import com.example.ikandra.Repository.Offer_imageRepository;

@Service
public class Offer_imageService {
    @Autowired
    private Offer_imageRepository offer_imageRepository;

    @Autowired
    private OfferRepositry offerRepositry;

    public List<Offer_image> getAll(){
        return offer_imageRepository.findAll();
    }

    public List<Offer_image> getByOffer(Long id){
        return offer_imageRepository.findByOffer_Id(id);
    }

    public List<Offer_image> create(Long id, List<MultipartFile> files){
        List<Offer_image> offerImages = new ArrayList<>();
        Offer existingOffer = offerRepositry.findById(id).orElse(null);
        String uploadDir = "Uploads/offerImage/";     
        int i =1; 
        for (MultipartFile multipartFile : files) {
            Offer_image newOffer_image= new Offer_image();
            String designation = "photo" +i;
            newOffer_image.setOffer(existingOffer);
            offer_imageRepository.save(newOffer_image);
            offer_imageRepository.flush();
            String fileName=FileUploadUtil.uploadFile(uploadDir,newOffer_image.getId(),multipartFile,designation);
            i++;
            newOffer_image.setImageUrl(fileName);
            offerImages.add(newOffer_image);
        }
        return offerImages;
    }

    public void deleteById(Long id){
        offer_imageRepository.deleteById(id);
    }

    public void deleteAll(){
        offer_imageRepository.deleteAll();
    }
}
