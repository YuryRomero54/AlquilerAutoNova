package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Alquiler;
import com.example.demo.modelo.Vehiculos;
import com.example.demo.repositorio.AlquilerDao;
import com.example.demo.repositorio.VehiculoDao;
import com.example.demo.service.AlquilerService;
import java.util.Optional;  



@Service
public class AlquilerServiceImpl implements AlquilerService {


	@Autowired
	AlquilerDao alquilerDao;
	
	@Autowired
	VehiculoDao vehiculoDao;
	

	@Override
	public List<Alquiler> getAlquileresPendientes(String estado) {
		return alquilerDao.findByEstado("pendiente");
	}
	@Override
	public Alquiler UpdateEstado(long idAlquiler, String estado) {
	    Alquiler alquiler = alquilerDao.findByIdAlquiler(idAlquiler);

	    if (alquiler == null) {
	        throw new RuntimeException("No se encontró el alquiler con ID " + idAlquiler);
	    }

	    alquiler.setEstado(estado);
	    return alquilerDao.save(alquiler);
	}
	@Override
	public Optional<Alquiler> getPlaca(String placa) {
		return alquilerDao.findByVehiculoPlaca(placa);
	}
	@Override
	public Vehiculos getIdAlquiler(long idAlquiler) {
	    Alquiler alquiler = alquilerDao.findByIdAlquiler(idAlquiler);
	    
	    if (alquiler == null) {
	        throw new RuntimeException("Alquiler no encontrado");
	    }
	    
	    return alquiler.getVehiculo();
	}



	
}

