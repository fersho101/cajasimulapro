package com.ferchoo.cajasimulapro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferchoo.cajasimulapro.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
