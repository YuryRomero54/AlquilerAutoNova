package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Vehiculos;

public interface VehiculoService {
	
	public List<Vehiculos> getDisponiblesPorTipoYestado(String tipo, String estado);
	
	Vehiculos getplaca(String placa);
	
	Vehiculos actualizarEstado(long idVehiculo,String estado);

}
