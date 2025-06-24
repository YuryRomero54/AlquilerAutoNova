package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.Alquiler;
import java.util.Optional;  



public interface AlquilerDao extends JpaRepository<Alquiler,Long>{
	
	List<Alquiler> findByEstado (String estado);
	
	Alquiler findByIdAlquiler(long idAlquiler);
	
	 @Query("SELECT a FROM Alquiler a JOIN FETCH a.vehiculo v WHERE v.placa = :placa")
	    Optional<Alquiler> findByVehiculoPlaca(@Param("placa") String placa);
	 
	
	 
	
}
