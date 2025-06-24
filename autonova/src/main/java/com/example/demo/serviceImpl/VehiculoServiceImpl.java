package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.Utils.AutoNovaUtils;
import com.example.demo.modelo.Vehiculos;
import com.example.demo.repositorio.VehiculoDao;
import com.example.demo.service.VehiculoService;



@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoDao vehiculoDao;
    

	@Override
	public List<Vehiculos> getDisponiblesPorTipoYestado(String tipo, String estado) {
		 return vehiculoDao.findByTipoAndEstado(tipo,"disponible");
	}


	@Override
	public Vehiculos getplaca(String placa) {
	
		return vehiculoDao.findByPlaca(placa) ;
	}


	@Override
	public Vehiculos actualizarEstado(long idVehiculo, String estado) {
	
			Vehiculos vehiculo=vehiculoDao.findByIdVehiculo(idVehiculo);
			
			if (vehiculo==null) {
		   throw new RuntimeException("No se encontró el Vehiculo con ID " + idVehiculo);
		   
			}
			vehiculo.setEstado("disponible");
			return vehiculoDao.save(vehiculo);
		
		
	}
	}

