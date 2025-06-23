package com.example.demo.controlador;

import com.example.demo.modelo.GestionAlquiler;
import com.example.demo.service.GestionAlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/gestion-alquiler")
@CrossOrigin(origins = "http://localhost:4200")
public class GestionAlquilerRest {

    @Autowired
    private GestionAlquilerService gestionAlquilerService;

    @PostMapping("/registrarGestion")
    public GestionAlquiler registrar(@RequestBody Map<String, String> body) {
        Long idAdmin = Long.parseLong(body.get("idAdmin"));
        Long idAlquiler = Long.parseLong(body.get("idAlquiler"));
        String observaciones = body.get("observaciones");

        return gestionAlquilerService.registrarGestion(idAdmin, idAlquiler, observaciones);
    }

    @GetMapping("/historial")
    public List<GestionAlquiler> historialPorAlquiler(@RequestParam Long idAlquiler) {
        return gestionAlquilerService.obtenerGestionesPorAlquiler(idAlquiler);
    }

    // ✅ Nuevo método para obtener todas las gestiones
    @GetMapping("/todas")
    public List<GestionAlquiler> obtenerTodas() {
        return gestionAlquilerService.obtenerTodasLasGestiones();
    }
}
