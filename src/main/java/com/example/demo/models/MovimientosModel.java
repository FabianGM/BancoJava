package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movimientos")
public class MovimientosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long movimientosId;

    private String numeroCuenta;
    private String tipo;
    private Double saldoInicial;
    private boolean estado;
    private String movimiento;
    private String fechaMovimiento;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private CuentaModel cuenta;

    @OneToMany(mappedBy = "movimientos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistorialMovimientoModel> historialMovimiento = new ArrayList<>();

    public Long getMovimientosId() {
        return movimientosId;
    }

    public void setMovimientosId(Long movimientosId) {
        this.movimientosId = movimientosId;
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
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public String getFecha() {
        return fechaMovimiento;
    }

    public void setFecha(String fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public CuentaModel getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaModel cuenta) {
        this.cuenta = cuenta;
    }

    public List<HistorialMovimientoModel> getHistorialMovimiento() {
        return historialMovimiento;
    }

    public void setHistorialMovimiento(List<HistorialMovimientoModel> historialMovimiento) {
        this.historialMovimiento = historialMovimiento;
    }

}