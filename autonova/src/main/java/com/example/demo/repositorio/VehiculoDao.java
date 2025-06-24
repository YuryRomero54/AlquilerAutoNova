package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Vehiculos;




public interface VehiculoDao  extends JpaRepository<Vehiculos,Long> {
	
	List<Vehiculos> findByTipoAndEstado(String tipo, String estado);
	List <Vehiculos>findByEstado(String estado);
	
	Vehiculos findByPlaca(String placa);
	
	Vehiculos findByIdVehiculo(long idVehiculo);
	
	

}
