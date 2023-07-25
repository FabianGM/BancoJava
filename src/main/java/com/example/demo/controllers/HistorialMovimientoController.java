package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.HistorialMovimientoModel;
import com.example.demo.services.HistorialMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movimientos/historial")
public class HistorialMovimientoController {
    @Autowired
    HistorialMovimientoService movimientoHistorialRepository;

    @GetMapping()
    public ArrayList<HistorialMovimientoModel> obtenerHistorialMovimientos() {
        return movimientoHistorialRepository.obtenerHistorialMovimientos();
    }

    @PostMapping()
    public HistorialMovimientoModel guardarMovimientoHistorial(@RequestBody HistorialMovimientoModel movimiento) {
        return this.movimientoHistorialRepository.guardarMovimientoHistorial(movimiento);
    }

    @GetMapping(path = "/{id}")
    public Optional<HistorialMovimientoModel> obtenerMovimientoPorId(@PathVariable("id") Long id) {
        return this.movimientoHistorialRepository.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialMovimientoModel> actualizarMovimiento(@PathVariable Long id,
            @RequestBody HistorialMovimientoModel movimientos) {
        HistorialMovimientoModel movimientosActualizado = movimientoHistorialRepository.actualizarMovimiento(id,
                movimientos);
        if (movimientosActualizado != null) {
            return ResponseEntity.ok(movimientosActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.movimientoHistorialRepository.eliminarMovimiento(id);
        if (ok) {
            return "Se eliminó el historial del movimiento con id " + id;
        } else {
            return "No pudo eliminar el historial del movimiento con id" + id;
        }
    }

}