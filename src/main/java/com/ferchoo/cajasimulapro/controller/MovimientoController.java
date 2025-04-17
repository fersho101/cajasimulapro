package com.ferchoo.cajasimulapro.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ferchoo.cajasimulapro.model.Cuenta;
import com.ferchoo.cajasimulapro.model.Movimiento;
import com.ferchoo.cajasimulapro.model.Movimiento.TipoMovimiento;
import com.ferchoo.cajasimulapro.repository.CuentaRepository;
import com.ferchoo.cajasimulapro.repository.MovimientoRepository;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private CuentaRepository cuentaRepository;

    @PostMapping("/depositar")
    public ResponseEntity<Movimiento> depositar(@RequestParam Long cuentaId, @RequestParam double monto) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId).orElseThrow();
        cuenta.setSaldo(cuenta.getSaldo() + monto);
        cuentaRepository.save(cuenta);

        Movimiento movimiento = new Movimiento();
        movimiento.setMonto(monto);
        movimiento.setTipo(TipoMovimiento.DEPOSITO);
        movimiento.setDescripcion("Deposito Realizado");
        movimiento.setFecha(LocalDateTime.now());
        movimiento.setCuenta(cuenta);

        return ResponseEntity.ok(movimientoRepository.save(movimiento));
    }

}
