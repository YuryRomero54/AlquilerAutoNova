package com.example.demo.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Vehiculos;

@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/vehiculos")
@RestController
public interface VehiculoRest {

    @GetMapping("/verdisponibles")
    List<Vehiculos> verDisponibles(@RequestParam("tipo") String tipo, @RequestParam("estado") String estado);
    
  @GetMapping("/buscarporplaca")
  public ResponseEntity<Vehiculos>buscarporplaca(@RequestParam("placa") String placa);
  
  @PutMapping("/actualizarEstado")
  public Vehiculos actualizarEstado(@RequestParam("idVehiculo")long idVehiculo,@RequestParam("estado")String estado);
    
}

