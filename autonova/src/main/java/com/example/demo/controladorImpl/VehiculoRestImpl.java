package com.example.demo.controladorImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Constantes.AutoNovaConstantes;
import com.example.demo.Utils.AutoNovaUtils;
import com.example.demo.controlador.VehiculoRest;
import com.example.demo.modelo.Vehiculos;
import com.example.demo.service.VehiculoService;

@RestController
public class VehiculoRestImpl implements VehiculoRest {
	@Autowired
	VehiculoService vehiculoService;

	@Override
	public List<Vehiculos> verDisponibles(String tipo, String estado) {
		// TODO Auto-generated method stub
		 try {
		        return vehiculoService.getDisponiblesPorTipoYestado(tipo,estado);
		    } catch (Exception ex) {
		        ex.printStackTrace();
		        return List.of(); 
		    }
		}

	@Override
	public ResponseEntity<Vehiculos> buscarporplaca(@RequestParam String placa) {
	    try {
	        Vehiculos vehiculo = vehiculoService.getplaca(placa);
	        if (vehiculo != null) {
	            return ResponseEntity.ok(vehiculo);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	@Override
	public Vehiculos actualizarEstado(long idVehiculo,String estado) {
		return vehiculoService.actualizarEstado(idVehiculo, estado);
		
	}}
