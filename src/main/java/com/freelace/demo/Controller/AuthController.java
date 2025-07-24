package com.freelace.demo.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freelace.demo.Auth.JWTUtil;
import com.freelace.demo.Dto.AuthResponse;
import com.freelace.demo.Dto.AuthRequest;
import com.freelace.demo.Dto.UserDto;
import com.freelace.demo.Model.User;
import com.freelace.demo.Repository.UserRepository;
import com.freelace.demo.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

            User user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            String token = jwtUtil.generateToken(user);
            return ResponseEntity.ok(new AuthResponse(token));

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestPart("user") String userJson,
                                    @RequestPart("file") MultipartFile file,
                                    @RequestPart("file2") MultipartFile file2,
                                    @RequestPart("file3") MultipartFile file3) {
        try {
            UserDto user = objectMapper.readValue(userJson, UserDto.class);

            if (userRepository.existsByEmail(user.getEmail())) {
                return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Cet email est déjà utilisé.");
            }

            User savedUser = userService.create(user, file, file2, file3);

            return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(savedUser.getNom_user());

        } catch (Exception e) {
            System.out.println("l'inscription n'a pas été envoyé");
            e.printStackTrace();
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erreur lors de l'inscription : " + e.getMessage());
        }
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart("id") Long id,  MultipartFile photo, String designation)
    {
        String photourl = "";
        try {
             if (photo != null && !photo.isEmpty()) {
                System.out.println("Photo reçue : " + photo.getOriginalFilename()); 
                System.out.println("designation: " + designation );

                 photourl = uploadFile(id, photo,designation);
            } else {
                System.out.println("La photo est null ou vide");
            }
            
        } catch (Exception e) {
             System.out.println("l'upload a échoué");
        }
        return photourl;
    }


}
