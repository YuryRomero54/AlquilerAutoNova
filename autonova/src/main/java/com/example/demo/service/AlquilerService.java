package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.modelo.Alquiler;
import com.example.demo.modelo.Vehiculos;

import java.util.Optional;  



public interface AlquilerService {
	
	List<Alquiler> getAlquileresPendientes(String estado);
	
	
	
	Alquiler UpdateEstado(long idAlquiler, String estado);
	

	
	public Optional<Alquiler> getPlaca(String placa);
	
	
	
    public Vehiculos getIdAlquiler(long idAlquiler);

}
