package com.example.demo.serviceImpl;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Constantes.AutoNovaConstantes;
import com.example.demo.JWT.JwtUtil;
import com.example.demo.Utils.AutoNovaUtils;
import com.example.demo.modelo.Usuario;
import com.example.demo.repositorio.UserDao;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside signUp {}", requestMap);
        
        try {
            if (validateSignUpMap(requestMap)) {
      
                Usuario usuario = userDao.findByCorreoUsuario(requestMap.get("correoUsuario"));
                
                if (Objects.isNull(usuario)) {
                    userDao.save(getUserFromMap(requestMap));
                    return AutoNovaUtils.getResponseEntity("Registro Exitoso", HttpStatus.OK);
                } else {
                    return AutoNovaUtils.getResponseEntity("El correo ya existe.", HttpStatus.BAD_REQUEST);
                }
            } else {
                return AutoNovaUtils.getResponseEntity(AutoNovaConstantes.Datos_Incorrectos, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return AutoNovaUtils.getResponseEntity(AutoNovaConstantes.ALGO_SALIO_MAL, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    private boolean validateSignUpMap(Map<String, String> requestMap) {
        
        if ( requestMap.containsKey("nombreCompleto") &&
            requestMap.containsKey("apellidos") && requestMap.containsKey("categoriaLicencia") &&
            requestMap.containsKey("telefono") && requestMap.containsKey("fechaExpedicionLicencia") &&
            requestMap.containsKey("vigencia") && requestMap.containsKey("correoUsuario") &&
            requestMap.containsKey("password")) {
            return true;
        }
        return false;
    }
    
    private Usuario getUserFromMap(Map<String, String> requestMap) {
        Usuario usuario = new Usuario();

        usuario.setNombreCompleto(requestMap.get("nombreCompleto"));
        usuario.setApellidos(requestMap.get("apellidos")); 
        usuario.setPassword(passwordEncoder.encode(requestMap.get("password")));
        usuario.setCategoriaLicencia(requestMap.get("categoriaLicencia"));
        usuario.setTelefono(requestMap.get("telefono"));
        usuario.setFechaExpedicionLicencia(LocalDate.parse(requestMap.get("fechaExpedicionLicencia")));
        usuario.setVigencia(LocalDate.parse(requestMap.get("vigencia")));
        usuario.setCorreoUsuario(requestMap.get("correoUsuario"));
        usuario.setRole("user");

        return usuario;
    }

    
    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        log.info("Inside login {}", requestMap);
        try {
            if (!requestMap.containsKey("correoUsuario") || !requestMap.containsKey("password")) {
                return AutoNovaUtils.getResponseEntity("Datos de login incompletos", HttpStatus.BAD_REQUEST);
            }

            Usuario usuario = userDao.findByCorreoUsuario(requestMap.get("correoUsuario"));

            if (Objects.isNull(usuario) || !usuario.getPassword().equals(requestMap.get("password"))) {
                return AutoNovaUtils.getResponseEntity("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
            }

            String token = jwtUtil.generateToken(usuario.getCorreoUsuario(), usuario.getRole());
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return AutoNovaUtils.getResponseEntity("Algo salió mal", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    


