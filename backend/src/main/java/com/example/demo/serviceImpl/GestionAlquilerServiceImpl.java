package com.example.demo.serviceImpl;

import com.example.demo.modelo.Admin;
import com.example.demo.modelo.Alquiler;
import com.example.demo.modelo.GestionAlquiler;
import com.example.demo.repositorio.AdminDao;
import com.example.demo.repositorio.AlquilerDao;
import com.example.demo.repositorio.GestionAlquilerDao;
import com.example.demo.service.GestionAlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GestionAlquilerServiceImpl implements GestionAlquilerService {

    @Autowired
    private GestionAlquilerDao gestionAlquilerDao;

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private AlquilerDao alquilerDao;

    @Override
    public GestionAlquiler registrarGestion(Long idAdmin, Long idAlquiler, String observaciones) {
        Admin admin = adminDao.findById(idAdmin)
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado"));

        Alquiler alquiler = alquilerDao.findById(idAlquiler)
                .orElseThrow(() -> new RuntimeException("Alquiler no encontrado"));

        GestionAlquiler gestion = new GestionAlquiler();
        gestion.setAdministrador(admin);
        gestion.setAlquiler(alquiler);
        gestion.setFecha_gestion(LocalDate.now());
        gestion.setObservaciones(observaciones);

        return gestionAlquilerDao.save(gestion);
    }

    @Override
    public List<GestionAlquiler> obtenerGestionesPorAlquiler(Long idAlquiler) {
        return gestionAlquilerDao.obtenerGestionesPorAlquiler(idAlquiler);
    }

    
    @Override
    public List<GestionAlquiler> obtenerTodasLasGestiones() {
        return gestionAlquilerDao.findAll();
    }
}
