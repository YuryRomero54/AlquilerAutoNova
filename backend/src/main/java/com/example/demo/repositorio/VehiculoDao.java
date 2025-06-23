package com.example.demo.repositorio;

import com.example.demo.modelo.Vehiculos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoDao extends JpaRepository<Vehiculos, Long> {
}
