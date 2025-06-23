package com.example.demo.repositorio;

import com.example.demo.modelo.GestionAlquiler;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GestionAlquilerDao extends JpaRepository<GestionAlquiler, Long> {

    @Query("SELECT g FROM GestionAlquiler g WHERE g.alquiler.id_alquiler = :idAlquiler")
    List<GestionAlquiler> obtenerGestionesPorAlquiler(@Param("idAlquiler") Long idAlquiler);
}
