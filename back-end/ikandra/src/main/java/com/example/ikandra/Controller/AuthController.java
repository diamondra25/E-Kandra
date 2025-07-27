package com.example.ikandra.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ikandra.Dto.AuthRequest;
import com.example.ikandra.Dto.AuthResponse;
import com.example.ikandra.Dto.RegisterRequestDto;
import com.example.ikandra.Jwt.JwtUtil;
import com.example.ikandra.Model.User;
import com.example.ikandra.Repository.UserRepository;
import com.example.ikandra.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

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
            return ResponseEntity.ok(new AuthResponse(token,user));

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping(value = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
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

            if (userRepository.existsByEmail(request.getEmail())) {
                return ResponseEntity.badRequest().body("Cet email est déjà utilisé.");
            }

            User user = userService.create(request, photo, cinRecto, cinVerso);
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

}

