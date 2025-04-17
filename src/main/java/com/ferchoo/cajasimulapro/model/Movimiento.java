package com.ferchoo.cajasimulapro.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "movimientos")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double monto;
    private String descripcion; // Ej. "Deposito inicial"
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipo;

    public enum TipoMovimiento {
        DEPOSITO, RETIRO
    }

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;

}
