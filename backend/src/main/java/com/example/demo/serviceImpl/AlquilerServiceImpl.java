package com.example.demo.serviceImpl;

import com.example.demo.modelo.Alquiler;
import com.example.demo.modelo.Vehiculos;
import com.example.demo.repositorio.AlquilerDao;
import com.example.demo.repositorio.VehiculoDao;
import com.example.demo.service.AlquilerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Service
public class AlquilerServiceImpl implements AlquilerService {

    @Autowired
    private AlquilerDao alquilerDao;

    @Autowired
    private VehiculoDao vehiculoDao;

    @Override
    public ResponseEntity<Map<String, String>> cancelarReserva(Long idUsuario, Long idAlquiler) {
        Map<String, String> respuesta = new HashMap<>();

        System.out.println("🔍 Iniciando cancelación");
        System.out.println("📥 ID Usuario recibido: " + idUsuario);
        System.out.println("📥 ID Alquiler recibido: " + idAlquiler);

        Optional<Alquiler> optionalAlquiler = alquilerDao.findById(idAlquiler);
        if (optionalAlquiler.isEmpty()) {
            respuesta.put("mensaje", "❌ La reserva no existe.");
            return ResponseEntity.badRequest().body(respuesta);
        }

        Alquiler alquiler = optionalAlquiler.get();

       
        if (alquiler.getUsuario().getIdUsuario() != idUsuario) {
            respuesta.put("mensaje", "❌ La reserva no pertenece a este usuario.");
            return ResponseEntity.badRequest().body(respuesta);
        }

        if (!alquiler.getEstado().equalsIgnoreCase("pendiente")) {
            respuesta.put("mensaje", "⚠️ Solo se pueden cancelar reservas en estado 'pendiente'.");
            return ResponseEntity.badRequest().body(respuesta);
        }

        alquiler.setEstado("cancelado");
        alquilerDao.save(alquiler);

        Vehiculos vehiculo = alquiler.getVehiculo();
        vehiculo.setDisponible(true);
        vehiculoDao.save(vehiculo);

        respuesta.put("mensaje", " Reserva cancelada exitosamente.");
        System.out.println(" Cancelación completada.");
        return ResponseEntity.ok(respuesta);
    }
}