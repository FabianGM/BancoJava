package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;
import com.example.demo.models.MovimientosModel;
import com.example.demo.services.MovimientoService;

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
@RequestMapping("/movimientos")
public class MovimientosController {
    @Autowired
    MovimientoService movimientoRepository;

    @GetMapping()
    public ArrayList<MovimientosModel> obtenerMovimientos() {
        return movimientoRepository.obtenerMovimientos();
    }

    @PostMapping()
    public MovimientosModel guardarMovimientos(@RequestBody MovimientosModel movimiento) {
        return this.movimientoRepository.guardarMovimiento(movimiento);
    }

    @GetMapping(path = "/{id}")
    public Optional<MovimientosModel> obtenerMovimientoPorId(@PathVariable("id") Long id) {
        return this.movimientoRepository.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimientosModel> actualizarMovimiento(@PathVariable Long id,
            @RequestBody MovimientosModel movimientos) {
        MovimientosModel movimientosActualizado = movimientoRepository.actualizarMovimiento(id, movimientos);
        if (movimientosActualizado != null) {
            return ResponseEntity.ok(movimientosActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.movimientoRepository.eliminarMovimiento(id);
        if (ok) {
            return "Se eliminó el movimiento con id " + id;
        } else {
            return "No pudo movimiento el cuenta con id" + id;
        }
    }

}