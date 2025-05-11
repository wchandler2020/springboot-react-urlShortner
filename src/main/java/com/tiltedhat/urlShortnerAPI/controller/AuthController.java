package com.tiltedhat.urlShortnerAPI.controller;

import com.tiltedhat.urlShortnerAPI.dto.LoginRequest;
import com.tiltedhat.urlShortnerAPI.dto.RegisterRequest;
import lombok.AllArgsConstructor;
import com.tiltedhat.urlShortnerAPI.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tiltedhat.urlShortnerAPI.service.UserService;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@CrossOrigin(origins = "https://spiffy-blini-477fea.netlify.app")
public class AuthController {

    private UserService userService;

    @PostMapping("/public/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(userService.loginUser(loginRequest));
    }

    @PostMapping("/public/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());
        user.setRole("ROLE_USER");
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
