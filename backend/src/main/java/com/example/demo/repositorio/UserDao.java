package com.example.demo.repositorio;

import com.example.demo.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<Usuario, Long> {
    Usuario findByCorreoUsuario(String correoUsuario);
}

