package com.example.demo.repositorio;

import com.example.demo.modelo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminDao extends JpaRepository<Admin, Long> { 
	    @Query("SELECT a FROM Admin a WHERE a.id_administrador = :id")
	    Admin buscarPorId(@Param("id") Long id);
	

}

