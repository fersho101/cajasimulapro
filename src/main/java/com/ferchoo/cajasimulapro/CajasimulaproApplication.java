package com.ferchoo.cajasimulapro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ferchoo.cajasimulapro.model.Usuario;
import com.ferchoo.cajasimulapro.repository.UsuarioRepository;

@SpringBootApplication
public class CajasimulaproApplication {

	public static void main(String[] args) {
		SpringApplication.run(CajasimulaproApplication.class, args);
	}

	// @Bean
	// CommandLineRunner init(UsuarioRepository usuarioRepo, PasswordEncoder encoder) {
	// 	return args -> {
	// 		Usuario admin = new Usuario();
	// 		admin.setEmail("admin@caja.com");
	// 		admin.setPassword(encoder.encode("123456"));
	// 		admin.setRol(Usuario.Rol.ADMIN);
	// 		usuarioRepo.save(admin);
	// 	};
	// }

}
