package com.example.demo.repositories;

import com.example.demo.models.MovimientosModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends CrudRepository<MovimientosModel, Long> {
}