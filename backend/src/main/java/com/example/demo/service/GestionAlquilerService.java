package com.example.demo.service;

import com.example.demo.modelo.GestionAlquiler;
import java.util.List;

public interface GestionAlquilerService {

    GestionAlquiler registrarGestion(Long idAdmin, Long idAlquiler, String observaciones);

    List<GestionAlquiler> obtenerGestionesPorAlquiler(Long idAlquiler);

    
    List<GestionAlquiler> obtenerTodasLasGestiones();
}
