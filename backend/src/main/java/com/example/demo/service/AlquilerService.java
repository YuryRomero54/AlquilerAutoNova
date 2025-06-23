package com.example.demo.service;
import java.util.Map;
import org.springframework.http.ResponseEntity;

public interface AlquilerService {
    ResponseEntity<Map<String, String>> cancelarReserva(Long idUsuario, Long idAlquiler);
}
