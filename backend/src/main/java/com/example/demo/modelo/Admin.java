package com.example.demo.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Administrador")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administrador") // 👈 Esta anotación es clave
    private Long id_administrador;

    private String usuario;
    private String password;

    public Admin() {
    }

    public Admin(Long id_administrador, String usuario, String password) {
        this.id_administrador = id_administrador;
        this.usuario = usuario;
        this.password = password;
    }

    public Long getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(Long id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
