package com.example.demo.repositories;

import com.example.demo.models.CuentaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentasRepository extends CrudRepository<CuentaModel, Long> {
}