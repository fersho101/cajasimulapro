package com.ferchoo.cajasimulapro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferchoo.cajasimulapro.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    Optional<Cuenta> findByUsuarioId(Long usuarioId);
}
