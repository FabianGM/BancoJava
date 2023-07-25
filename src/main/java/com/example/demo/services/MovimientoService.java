package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.MovimientosModel;
import com.example.demo.repositories.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientoService {
    @Autowired
    MovimientoRepository movimientoRepository;

    public ArrayList<MovimientosModel> obtenerMovimientos() {
        return (ArrayList<MovimientosModel>) movimientoRepository.findAll();
    }

    public MovimientosModel guardarMovimiento(MovimientosModel movimiento) {
        return movimientoRepository.save(movimiento);
    }

    public Optional<MovimientosModel> obtenerPorId(Long id) {
        return movimientoRepository.findById(id);
    }

    public MovimientosModel actualizarMovimiento(Long id, MovimientosModel movimientoActualizado) {
        Optional<MovimientosModel> movimientoExistenteOpcional = movimientoRepository.findById(id);
        if (movimientoExistenteOpcional.isPresent()) {
            MovimientosModel movimientoExistente = movimientoExistenteOpcional.get();

            movimientoExistente.setNumeroCuenta(movimientoActualizado.getNumeroCuenta());
            movimientoExistente.setTipo(movimientoActualizado.getTipo());
            movimientoExistente.setSaldoInicial(movimientoActualizado.getSaldoInicial());
            movimientoExistente.setEstado(movimientoActualizado.isEstado());
            movimientoExistente.setMovimiento(movimientoActualizado.getMovimiento());
            movimientoExistente.setFecha(movimientoActualizado.getFecha());

            return movimientoRepository.save(movimientoExistente);
        } else {
            return null;
        }
    }

    public boolean eliminarMovimiento(Long id) {
        try {
            movimientoRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}