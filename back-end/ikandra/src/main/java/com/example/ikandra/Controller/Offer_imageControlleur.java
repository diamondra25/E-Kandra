package com.example.ikandra.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ikandra.Model.Offer_image;
import com.example.ikandra.Service.Offer_imageService;


@RestController
@RequestMapping("/offer_images")
public class Offer_imageControlleur {
    @Autowired
    private Offer_imageService offer_imageService;

    @GetMapping()
    public List<Offer_image> getAll(){
        return offer_imageService.getAll();
    }

    @GetMapping("/getByOffer")
    public List<Offer_image> getByOffer(@RequestParam("id") Long id){
        return offer_imageService.getByOffer(id);
    }

    @CrossOrigin
    @PostMapping(value = "/creates", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public List<Offer_image> create(
        @RequestParam("offerId") Long offerId,
        @RequestPart("files") List<MultipartFile> files){
        List<Offer_image> newOffer_images=  offer_imageService.create(offerId, files);
        return newOffer_images;
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam("id") Long id){
        offer_imageService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        offer_imageService.deleteAll();
    }
}

