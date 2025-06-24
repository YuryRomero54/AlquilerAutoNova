package com.example.demo.JWT;

import com.example.demo.modelo.Usuario;
import com.example.demo.repositorio.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@Service
public class CustomerUsersDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    private Usuario userDetail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserByUsername: {}", username);
        userDetail = userDao.findByCorreoUsuario(username);
        if (!Objects.isNull(userDetail)) {
            return new org.springframework.security.core.userdetails.User(
                    userDetail.getCorreoUsuario(),
                    userDetail.getPassword(),
                    new ArrayList<>()
            );
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

    public Usuario getUserDetail() {
        return userDetail;
    }
}

