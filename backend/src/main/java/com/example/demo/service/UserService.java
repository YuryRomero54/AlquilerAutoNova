package com.example.demo.service;

import com.example.demo.modelo.Usuario;
import com.example.demo.repositorio.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    private Map<String, Integer> intentosFallidos = new HashMap<>();
    private Map<String, LocalDateTime> bloqueos = new HashMap<>();

    private static final int MAX_INTENTOS = 3;
    private static final int MINUTOS_BLOQUEO = 5;

    public ResponseEntity<?> autenticarUsuario(String correo, String password) {
        if (correo == null || password == null || correo.isBlank() || password.isBlank()) {
            return ResponseEntity.badRequest().body(Map.of(
                "error", "Debe ingresar correo y contraseña"
            ));
        }

        // Verificar si el usuario está temporalmente bloqueado
        if (bloqueos.containsKey(correo)) {
            LocalDateTime desbloqueo = bloqueos.get(correo);
            if (LocalDateTime.now().isBefore(desbloqueo)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of(
                    "error", "Cuenta bloqueada hasta " + desbloqueo.toLocalTime()
                ));
            } else {
                bloqueos.remove(correo);
                intentosFallidos.put(correo, 0);
            }
        }

        // Buscar usuario
        Usuario usuario = userDao.findByCorreoUsuario(correo);
        if (usuario == null || !usuario.getPassword().equals(password)) {
            int intentos = intentosFallidos.getOrDefault(correo, 0) + 1;
            intentosFallidos.put(correo, intentos);

            if (intentos >= MAX_INTENTOS) {
                bloqueos.put(correo, LocalDateTime.now().plusMinutes(MINUTOS_BLOQUEO));
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of(
                    "error", "Demasiados intentos. Cuenta bloqueada por 5 minutos"
                ));
            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                "error", "Correo o contraseña incorrectos",
                "intentosRestantes", MAX_INTENTOS - intentos
            ));
        }

        // Login exitoso
        intentosFallidos.put(correo, 0);
        LocalDateTime horaLogin = LocalDateTime.now();

        Map<String, Object> usuarioMap = new HashMap<>();
        usuarioMap.put("id", usuario.getIdUsuario());
        usuarioMap.put("nombre", usuario.getNombreCompleto());
        usuarioMap.put("correo", usuario.getCorreoUsuario());
        usuarioMap.put("rol", usuario.getRole());

        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Inicio de sesión exitoso");
        response.put("horaInicioSesion", horaLogin.toString());
        response.put("usuario", usuarioMap);

        if ("Administrador".equalsIgnoreCase(usuario.getRole())) {
            response.put("redireccion", "/admin/dashboard");
        } else {
            response.put("redireccion", "/panel/usuario/inicio");
        }

        return ResponseEntity.ok(response);
    }
}
