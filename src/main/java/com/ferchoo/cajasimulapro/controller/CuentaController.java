package com.ferchoo.cajasimulapro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferchoo.cajasimulapro.model.Cuenta;
import com.ferchoo.cajasimulapro.repository.CuentaRepository;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Cuenta> getCuentaByUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(cuentaRepository.findByUsuarioId(usuarioId).orElseThrow());
    }

}
