package com.example.demo.controlador;

import com.example.demo.modelo.Usuario;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/usuario")
public class UserRest {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario datos) {
        return userService.autenticarUsuario(datos.getCorreoUsuario(), datos.getPassword());
    }
}
