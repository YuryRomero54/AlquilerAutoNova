package com.example.demo.controladorImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Constantes.AutoNovaConstantes;
import com.example.demo.controlador.AlquilerRest;
import com.example.demo.modelo.Alquiler;
import com.example.demo.modelo.Vehiculos;
import com.example.demo.service.AlquilerService;
@RestController
public class AlquilerRestImpl implements AlquilerRest {

	@Autowired
	AlquilerService alquilerService;
	
	AutoNovaConstantes autonovacons;
	
	@Override
	public List<Alquiler> AlquileresPendientes() {
		
		try {
	        return alquilerService.getAlquileresPendientes("pendiente");
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return List.of(); 
	    }
	}

	@Override
	public Alquiler actualizarEstadoAlquiler(long idAlquiler,String estado ) {
		try {
	        return alquilerService.UpdateEstado(idAlquiler,estado);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return (Alquiler) List.of(); 
	    }
	}

	@Override
	public ResponseEntity<?> obtenerAlquilerPorPlaca(String placa) {
		return alquilerService.getPlaca(placa)
                .map(alquiler -> ResponseEntity.ok(alquiler))
                .orElse(ResponseEntity.notFound().build());
    }

	@Override
	public Vehiculos obtenerAlquilerPorId(long idAlquiler) {
		
		try {
		return alquilerService.getIdAlquiler(idAlquiler);
		}catch(Exception ex) {
	        ex.printStackTrace();
		    return null;
		
	}
}}

