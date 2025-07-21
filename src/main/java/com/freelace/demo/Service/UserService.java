package com.freelace.demo.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.freelace.demo.Dto.UserDto;
import com.freelace.demo.Model.User;
import com.freelace.demo.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id_user) {
        return userRepository.findById(id_user).orElse(null);
    }

    public User create(UserDto userDto) {
        User user = new User();
        MultipartFile file = userDto.getPhoto();
        try{
            user.setNom_user(userDto.getNom_user());
            user.setPseudo(userDto.getPseudo());
            user.setEmail(userDto.getEmail());
            user.setRole(userDto.getRole());
            user.setPassword(userDto.getPassword());
            user.setBio(userDto.getBio());
            user.setPhone(userDto.getPhone());
            user.setIs_active(false);

            userRepository.save(user);

            if (file != null && !file.isEmpty()) {
                String uploadDir = "uploads/user/";
                Files.createDirectories(Path.of(uploadDir));

                String fileName = "user_" + user.getId() + "_" + file.getOriginalFilename();
                Path filePath = Paths.get(uploadDir, fileName);
                Files.write(filePath, file.getBytes());

                String fileUrl = "/images/" + fileName;
                user.setPhoto_url(fileUrl);

                user = userRepository.save(user);
            }
        }
        catch(Exception e ){
            System.err.println("l'inscription n'a pas été envoyé");
        }

        return user;    
    }

    public User update(Long id_user, User userDetails) {
        User user = userRepository.findById(id_user).orElse(null);
        if (user != null) {
            user.setNom_user(userDetails.getNom_user());
            user.setPhoto_url(userDetails.getPhoto_url());
            user.setPseudo(userDetails.getPseudo());
            user.setEmail(userDetails.getEmail());
            user.setRole(userDetails.getRole());
            user.setPassword(userDetails.getPassword());
            user.setBio(userDetails.getBio());
            user.setPhone(userDetails.getPhone());
            user.setIs_active(userDetails.getIs_active());
            return userRepository.save(user);
        }
        return null;
    }

    public void delete(Long id_user) {
        userRepository.deleteById(id_user);
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }


}
