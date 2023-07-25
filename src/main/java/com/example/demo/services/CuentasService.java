package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.CuentaModel;
import com.example.demo.repositories.CuentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentasService {
    @Autowired
    CuentasRepository cuentasRepository;

    public ArrayList<CuentaModel> obtenerCuentas() {
        return (ArrayList<CuentaModel>) cuentasRepository.findAll();
    }

    public CuentaModel guardarCuentas(CuentaModel cuentas) {
        return cuentasRepository.save(cuentas);
    }

    public Optional<CuentaModel> obtenerPorId(Long id) {
        return cuentasRepository.findById(id);
    }

    public CuentaModel actualizarCuenta(Long id, CuentaModel cuentaActualizada) {
        Optional<CuentaModel> cuentaExistenteOpcional = cuentasRepository.findById(id);
        if (cuentaExistenteOpcional.isPresent()) {
            CuentaModel cuentaExistente = cuentaExistenteOpcional.get();
            cuentaExistente.setNumeroCuenta(cuentaActualizada.getNumeroCuenta());
            cuentaExistente.setTipoCuenta(cuentaActualizada.getTipoCuenta());
            cuentaExistente.setSaldoInicial(cuentaActualizada.getSaldoInicial());
            cuentaExistente.setUsuarioCuenta(cuentaActualizada.getUsuarioCuenta());
            cuentaExistente.setEstado(cuentaActualizada.isEstado());
            return cuentasRepository.save(cuentaExistente);
        } else {
            return null;
        }
    }

    public boolean eliminarCuenta(Long id) {
        try {
            cuentasRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}