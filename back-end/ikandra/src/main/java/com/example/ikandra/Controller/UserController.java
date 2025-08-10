package com.example.ikandra.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ikandra.Dto.AuthResponse;
import com.example.ikandra.Dto.RegisterRequestDto;
import com.example.ikandra.Jwt.JwtUtil;
import com.example.ikandra.Model.User;
import com.example.ikandra.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping()
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getAllByIs_active")
    public List<User> getAllByIs_active(@RequestParam("is_active") Boolean is_active){
        return userService.getAllByIs_active(is_active);
    }

    @GetMapping("/getByEmail")
    public Optional<User> getByEmail(@RequestParam("email")String email){
        System.out.println("Email reçu en paramètre : " + email);
        return userService.getByEmail(email);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PutMapping( consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> register(
            @RequestPart("user") String userJson,
            @RequestPart(value = "photo", required = false) MultipartFile photo,
            @RequestPart("cin_recto") MultipartFile cinRecto,
            @RequestPart("cin_verso") MultipartFile cinVerso
        ) {
            try {
                if (cinRecto == null || cinVerso == null) {
                    return ResponseEntity.badRequest().body("Les fichiers cin_recto et cin_verso sont requis.");
                }

                RegisterRequestDto request = objectMapper.readValue(userJson, RegisterRequestDto.class);

                User user = userService.update(request, photo, cinRecto, cinVerso);
                String token = jwtUtil.generateToken(user);
                return ResponseEntity.status(HttpStatus.CREATED).body(new AuthResponse(token,user));
            } catch (JsonProcessingException e) {
                return ResponseEntity.badRequest().body("Erreur de format JSON : " + e.getMessage());
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body("Données invalides : " + e.getMessage());
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                    .body("Erreur serveur : " + e.getMessage());
            }
    }

    @PutMapping("/activateAccount")
    public User activateAccount(@RequestParam("id") Long id){
        return userService.activateAccount(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
         userService.deleteById(id);
    }

    @DeleteMapping("")
    public void deleteAll(){
         userService.deleteAll();;
    }



}
