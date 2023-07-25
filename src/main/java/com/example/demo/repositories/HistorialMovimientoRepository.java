package com.example.demo.repositories;

import com.example.demo.models.HistorialMovimientoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialMovimientoRepository extends CrudRepository<HistorialMovimientoModel, Long> {
}