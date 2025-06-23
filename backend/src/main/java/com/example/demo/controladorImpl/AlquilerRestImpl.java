package com.example.demo.controladorImpl;

import com.example.demo.service.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/alquiler")
public class AlquilerRestImpl {

    @Autowired
    private AlquilerService alquilerService;

    @CrossOrigin(origins = "http://localhost:4200") 
    @PostMapping("/cancelar")
    public ResponseEntity<Map<String, String>> cancelarReserva(@RequestBody Map<String, Long> datos) {
        Long idUsuario = datos.get("idUsuario");
        Long idAlquiler = datos.get("idAlquiler");
        return alquilerService.cancelarReserva(idUsuario, idAlquiler);
    }
}


