package com.freelace.demo.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.freelace.demo.Dto.UserDto;
import com.freelace.demo.Enumeration.UserEnum.UserType;
import com.freelace.demo.Model.User;
import com.freelace.demo.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }    
    
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id_user) {
        return userRepository.findById(id_user).orElse(null);
    }

    @Transactional
    public User create(UserDto userDto, MultipartFile photo, MultipartFile photo2, MultipartFile photo3) {
        User user = new User();
        try {
            user.setNom_user(userDto.getNom_user());
            user.setPrenom(userDto.getPrenom());
            user.setPseudo(userDto.getPseudo());
            user.setEmail(userDto.getEmail());
            user.setRole(UserType.valueOf(userDto.getRole().toUpperCase()));
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));            
            user.setBio(userDto.getBio());
            user.setPhone(userDto.getPhone());
            user.setSolde(userDto.getSolde());
            user.setIs_active(userDto.getIs_active());

            user = userRepository.save(user);
            userRepository.flush();
                        
            if (photo != null && !photo.isEmpty()) {
                System.out.println("Photo reçue : " + photo.getOriginalFilename()); // Debug
                System.out.println("designation: " + userDto.getDesignation()); // Debug

                String photourl = uploadFile(user.getId(), photo, userDto.getDesignation());
                String rectourl = uploadFile(user.getId(), photo2, userDto.getDesignation2());
                String versourl = uploadFile(user.getId(), photo3, userDto.getDesignation3());

                System.out.println("Photo URL générée : " + photourl); // Debug
                    user.setPhoto_url(photourl);
                    user.setCin_recto_url(rectourl);
                    user.setCin_verso_url(versourl);
                    user = userRepository.save(user);
                    System.out.println("Photo URL sauvegardée : " + user.getPhoto_url()); // Debug
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.err.println("L'inscription n'a pas été envoyée : " + e.getMessage());
        }
        return user;    
    }

    public String uploadFile(Long id_user, MultipartFile file, String designation) {
    String fileUrl = "";
    try {
        String uploadDir = "uploads/user/";
        Files.createDirectories(Path.of(uploadDir));
        
        String prefix = (designation != null && !designation.isEmpty()) ? designation + "_" : "";
        String fileName = prefix + id_user + "_" + file.getOriginalFilename();
        
        Path filePath = Paths.get(uploadDir, fileName);
        Files.write(filePath, file.getBytes());
        
        fileUrl = "uploads/user/" + fileName;
        
        System.out.println("Fichier uploadé avec succès : " + fileUrl); 
        
    } catch(Exception e) {
        System.err.println("Problème de fichier : " + e.getMessage());
        e.printStackTrace();
    }
     return fileUrl;
    }

    public User update(Long id_user, UserDto userDto, MultipartFile photo, MultipartFile photo2, MultipartFile photo3) {
        User user = userRepository.findById(id_user).orElse(null);
        try {
            user.setNom_user(userDto.getNom_user());
            user.setPrenom(userDto.getPrenom());
            user.setPseudo(userDto.getPseudo());
            user.setEmail(userDto.getEmail());
            user.setRole(UserType.valueOf(userDto.getRole().toUpperCase()));
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));            
            user.setBio(userDto.getBio());
            user.setPhone(userDto.getPhone());
            user.setSolde(userDto.getSolde());
            user.setIs_active(userDto.getIs_active());

            user = userRepository.save(user);
            userRepository.flush();
                        
            if (photo != null && !photo.isEmpty()) {


                String photourl = uploadFile(user.getId(), photo, userDto.getDesignation());
                String rectourl = uploadFile(user.getId(), photo2, userDto.getDesignation2());
                String versourl = uploadFile(user.getId(), photo3, userDto.getDesignation3());

                System.out.println("Photo URL générée : " + photourl); 
                    user.setPhoto_url(photourl);
                    user.setCin_recto_url(rectourl);
                    user.setCin_verso_url(versourl);
                    user = userRepository.save(user);
                    System.out.println("Photo URL sauvegardée : " + user.getPhoto_url()); 
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.err.println("L'inscription n'a pas été envoyée : " + e.getMessage());
        }
        return user;    
    }

    public void delete(Long id_user) {
        userRepository.deleteById(id_user);
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }


}
