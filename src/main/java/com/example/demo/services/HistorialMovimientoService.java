package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;
import com.example.demo.models.HistorialMovimientoModel;
import com.example.demo.repositories.HistorialMovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialMovimientoService {
    @Autowired
    HistorialMovimientoRepository movimientoHistorialRepository;

    public ArrayList<HistorialMovimientoModel> obtenerHistorialMovimientos() {
        return (ArrayList<HistorialMovimientoModel>) movimientoHistorialRepository.findAll();
    }

    public HistorialMovimientoModel guardarMovimientoHistorial(HistorialMovimientoModel movimiento) {
        return movimientoHistorialRepository.save(movimiento);
    }

    public Optional<HistorialMovimientoModel> obtenerPorId(Long id) {
        return movimientoHistorialRepository.findById(id);
    }

    public HistorialMovimientoModel actualizarMovimiento(Long id, HistorialMovimientoModel movimientoActualizado) {
        Optional<HistorialMovimientoModel> movimientoExistenteOpcional = movimientoHistorialRepository.findById(id);
        if (movimientoExistenteOpcional.isPresent()) {
            HistorialMovimientoModel movimientoExistente = movimientoExistenteOpcional.get();

            movimientoExistente.setNumeroCuenta(movimientoActualizado.getNumeroCuenta());
            movimientoExistente.setTipo(movimientoActualizado.getTipo());
            movimientoExistente.setSaldoInicial(movimientoActualizado.getSaldoInicial());
            movimientoExistente.setEstado(movimientoActualizado.isEstado());
            movimientoExistente.setMovimiento(movimientoActualizado.getMovimiento());
            movimientoExistente.setFecha(movimientoActualizado.isFecha());
            movimientoExistente.setUsario(movimientoActualizado.getUsario());
            movimientoExistente.setSaldoDisponible(movimientoActualizado.getSaldoDisponible());

            return movimientoHistorialRepository.save(movimientoExistente);
        } else {
            return null;
        }
    }

    public boolean eliminarMovimiento(Long id) {
        try {
            movimientoHistorialRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}