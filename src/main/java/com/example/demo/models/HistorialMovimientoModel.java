package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historialmovimientos")
public class HistorialMovimientoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long movimientosFechaId;

    private String usario;
    private String numeroCuenta;
    private String tipo;
    private Double saldoInicial;
    private Double saldoDisponible;
    private boolean estado;
    private String movimientoHistorial;
    private String fechaMovimientoHistorial;

    @ManyToOne
    @JoinColumn(name = "movimientos_id")
    private MovimientosModel movimientos;

    public String getUsario() {
        return usario;
    }

    public void setUsario(String usario) {
        this.usario = usario;
    }

    public Double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(Double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public Long getMovimientosFechaId() {
        return movimientosFechaId;
    }

    public void setMovimientosFechaId(Long movimientosFechaId) {
        this.movimientosFechaId = movimientosFechaId;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getMovimiento() {
        return movimientoHistorial;
    }

    public void setMovimiento(String movimientoHistorial) {
        this.movimientoHistorial = movimientoHistorial;
    }

    public String isFecha() {
        return fechaMovimientoHistorial;
    }

    public void setFecha(String fechaMovimientoHistorial) {
        this.fechaMovimientoHistorial = fechaMovimientoHistorial;
    }

}