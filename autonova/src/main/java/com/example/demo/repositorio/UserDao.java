package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.Usuario;


public interface UserDao extends JpaRepository<Usuario,Long> {
	
	 Usuario findByCorreoUsuario(String correoUsuario);
}