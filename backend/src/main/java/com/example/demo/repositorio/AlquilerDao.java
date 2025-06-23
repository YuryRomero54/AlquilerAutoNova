package com.example.demo.repositorio;

import com.example.demo.modelo.Alquiler;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquilerDao extends JpaRepository<Alquiler, Long> {
	    List<Alquiler> findByUsuario_IdUsuarioAndEstado(Long idUsuario, String estado);
	}

    

