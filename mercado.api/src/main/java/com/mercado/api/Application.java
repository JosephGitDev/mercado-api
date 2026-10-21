package com.mercado.api;

import com.mercado.api.entity.Usuario;
import com.mercado.api.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner initData(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername("admin");
			Usuario admin;
			if (usuarioOpt.isPresent()) {
				admin = usuarioOpt.get();
			} else {
				admin = new Usuario();
				admin.setUsername("admin");
				admin.setEstado(true);
			}
			// Forzamos la encriptación correcta de 'admin123' cada vez que arranca
			admin.setPassword(passwordEncoder.encode("admin123"));
			usuarioRepository.save(admin);
			System.out.println(">>> Usuario 'admin' sincronizado con contraseña cifrada correctamente.");
		};
	}
}