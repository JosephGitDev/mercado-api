package com.mercado.api.service;

import com.mercado.api.dto.LoginRequest;
import com.mercado.api.dto.LoginResponse;
import com.mercado.api.entity.Usuario;
import com.mercado.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponse autenticar(LoginRequest loginRequest) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(loginRequest.getUsername());

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            // Verifica que la contraseña coincida con el hash BCrypt
            if (passwordEncoder.matches(loginRequest.getPassword(), usuario.getPassword())) {
                return new LoginResponse("Autenticación exitosa", true, usuario.getUsername());
            }
        }
        return new LoginResponse("Credenciales incorrectas", false, null);
    }
}