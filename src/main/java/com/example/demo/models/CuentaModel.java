package com.example.demo.models;

import java.util.List;
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
@Table(name = "cuenta")
public class CuentaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long cuentaId;

    private String numeroCuenta;
    private String tipoCuenta;
    private Integer saldoInicial;
    private String usuarioCuenta;
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;

    @OneToMany(mappedBy = "cuenta")
    private List<MovimientosModel> movimientos;

    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Integer getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Integer saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public String getUsuarioCuenta() {
        return usuarioCuenta;
    }

    public void setUsuarioCuenta(String usuarioCuenta) {
        this.usuarioCuenta = usuarioCuenta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public List<MovimientosModel> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientosModel> movimientos) {
        this.movimientos = movimientos;
    }

}