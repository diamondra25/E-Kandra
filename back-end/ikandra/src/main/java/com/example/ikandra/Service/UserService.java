package com.example.ikandra.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ikandra.Context.FileUploadUtil;
import com.example.ikandra.Dto.RegisterRequestDto;
import com.example.ikandra.Enumeration.UserEnum.UserType;
import com.example.ikandra.Model.User;
import com.example.ikandra.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public User getById(Long id){
        return userRepo.findById(id).orElse(null);
    }

    @Transactional
    public User create(RegisterRequestDto userDto, MultipartFile photo, MultipartFile cin_recto, MultipartFile cin_verso) {
        User user = new User();
        try {
            user.setNom_user(userDto.getNom_user());
            user.setPrenom(userDto.getPrenom());
            user.setPseudo(userDto.getPseudo());
            user.setEmail(userDto.getEmail());
            user.setRole(UserType.valueOf(userDto.getRole()));
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setBio(userDto.getBio());
            user.setPhone(userDto.getPhone());
            user.setSolde(userDto.getSolde());
            user.setIs_active(false);

            user = userRepo.save(user);

            if (photo != null && !photo.isEmpty() && cin_recto != null && !cin_recto.isEmpty() && cin_verso != null && !cin_verso.isEmpty()) {
                String uploadDir = "Uploads/user/";

                String designation = userDto.getDesignation() != null ? userDto.getDesignation() : "photo_";
                String designation2 = userDto.getDesignation2() != null ? userDto.getDesignation2() : "cin_recto_";
                String designation3 = userDto.getDesignation3() != null ? userDto.getDesignation3() : "cin_verso_";

                String fileName=FileUploadUtil.uploadFile(uploadDir,user.getId(),photo,designation);
                String fileCinName1=FileUploadUtil.uploadFile(uploadDir,user.getId(),cin_recto,designation2);
                String fileCinName2=FileUploadUtil.uploadFile(uploadDir,user.getId(),cin_verso,designation3);

                user.setPhoto_url( fileName);
                user.setCin_recto_url(fileCinName1);
                user.setCin_verso_url(fileCinName2);

                user = userRepo.save(user);
            } else {
                throw new IllegalArgumentException("Un ou plusieurs fichiers sont vides ou manquants.");
            }

            return user;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la création de l'utilisateur : " + e.getMessage(), e);
        }
    }

    @Transactional
    public User update(RegisterRequestDto userDto, MultipartFile photo, MultipartFile cin_recto, MultipartFile cin_verso) {
        User user = new User();
        try {
            user.setNom_user(userDto.getNom_user());
            user.setPrenom(userDto.getPrenom());
            user.setPseudo(userDto.getPseudo());
            user.setEmail(userDto.getEmail());
            user.setRole(UserType.valueOf(userDto.getRole()));
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setBio(userDto.getBio());
            user.setPhone(userDto.getPhone());
            user.setSolde(userDto.getSolde());
            user.setIs_active(true);

            user = userRepo.save(user);

            if (photo != null && !photo.isEmpty() && cin_recto != null && !cin_recto.isEmpty() && cin_verso != null && !cin_verso.isEmpty()) {
                String uploadDir = "Uploads/user/";

                String designation = userDto.getDesignation() != null ? userDto.getDesignation() : "photo_";
                String designation2 = userDto.getDesignation2() != null ? userDto.getDesignation2() : "cin_recto_";
                String designation3 = userDto.getDesignation3() != null ? userDto.getDesignation3() : "cin_verso_";

                String fileName=FileUploadUtil.uploadFile(uploadDir,user.getId(),photo,designation);
                String fileCinName1=FileUploadUtil.uploadFile(uploadDir,user.getId(),cin_recto,designation2);
                String fileCinName2=FileUploadUtil.uploadFile(uploadDir,user.getId(),cin_verso,designation3);

                user.setPhoto_url( fileName);
                user.setCin_recto_url(fileCinName1);
                user.setCin_verso_url(fileCinName2);

                user = userRepo.save(user);
            } else {
                throw new IllegalArgumentException("Un ou plusieurs fichiers sont vides ou manquants.");
            }

            return user;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la création de l'utilisateur : " + e.getMessage(), e);
        }
    }

    public void deleteById(Long id){
         userRepo.deleteById(id);
    }

    public void deleteAll(){
        userRepo.deleteAll();
    }

    public List<User> getAllByIs_active(Boolean is_active){
        return userRepo.findAllByIs_active(is_active);
    }

    public Optional<User> getByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public Boolean existsByEmail(String email){
        return userRepo.existsByEmail(email);
    }

    public User activateAccount(Long Id){
        User user = userRepo.findById(Id).orElse(null);
        Boolean status=user.getIs_active();
        user.setIs_active(!status);
        return userRepo.save(user);
    }

    


}
