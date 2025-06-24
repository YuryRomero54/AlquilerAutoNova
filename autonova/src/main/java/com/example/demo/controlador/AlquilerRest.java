package com.example.demo.controlador;
import com.example.demo.modelo.Alquiler;
import com.example.demo.modelo.Vehiculos;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/alquileres")
@RestController
public interface AlquilerRest {
	
	@GetMapping("/pendientes")
	List<Alquiler> AlquileresPendientes ();
	
	@GetMapping("/buscarAlquiler")
	public ResponseEntity<?> obtenerAlquilerPorPlaca(@RequestParam String placa) ;
	
	@PutMapping("/actualizarestado")
    Alquiler actualizarEstadoAlquiler(@RequestParam
    		("idAlquiler") long idAlquiler,@RequestParam("estado") String estado);
	
	@GetMapping("/buscarVehiculoporAlquilerId")
	public Vehiculos obtenerAlquilerPorId(@RequestParam long idAlquiler) ;
	
}
