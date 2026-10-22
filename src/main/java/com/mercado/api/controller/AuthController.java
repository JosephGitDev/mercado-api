package com.mercado.api.controller;

import com.mercado.api.dto.LoginRequest;
import com.mercado.api.dto.LoginResponse;
import com.mercado.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse respuesta = authService.autenticar(loginRequest);
        if (respuesta.getExito()) {
            return ResponseEntity.ok(respuesta);
        }
        return ResponseEntity.status(401).body(respuesta);
    }
}