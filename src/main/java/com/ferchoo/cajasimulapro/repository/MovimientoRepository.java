package com.ferchoo.cajasimulapro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferchoo.cajasimulapro.model.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByCuentaId(Long cuentaId);
}
