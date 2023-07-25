package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;
import com.example.demo.models.CuentaModel;
import com.example.demo.services.CuentasService;
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
@RequestMapping("/cuentas")
public class CuentasController {
    @Autowired
    CuentasService cuentasRepository;

    @GetMapping()
    public ArrayList<CuentaModel> obtenerCuentas() {
        return cuentasRepository.obtenerCuentas();
    }

    @PostMapping()
    public CuentaModel guardarCuenta(@RequestBody CuentaModel cuenta) {
        return this.cuentasRepository.guardarCuentas(cuenta);
    }

    @GetMapping(path = "/{id}")
    public Optional<CuentaModel> obtenerCuentaPorId(@PathVariable("id") Long id) {
        return this.cuentasRepository.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuentaModel> actualizarCuenta(@PathVariable Long id, @RequestBody CuentaModel cuentas) {
        CuentaModel cuentasActualizado = cuentasRepository.actualizarCuenta(id, cuentas);
        if (cuentasActualizado != null) {
            return ResponseEntity.ok(cuentasActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.cuentasRepository.eliminarCuenta(id);
        if (ok) {
            return "Se eliminó el cuenta con id " + id;
        } else {
            return "No pudo eliminar el cuenta con id" + id;
        }
    }

}