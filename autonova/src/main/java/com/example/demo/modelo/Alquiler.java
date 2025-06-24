package com.example.demo.modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Alquiler")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlquiler")
    private Long idAlquiler;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculos vehiculo;

    private LocalDate fecha_inicio;
    private LocalDate fecha_entrega;
    private String estado;
    private Double valor;

    public Alquiler() {
    	
    }

    public Alquiler(Long idAlquiler, Usuario usuario, Vehiculos vehiculo,
                    LocalDate fecha_inicio, LocalDate fecha_entrega,
                    String estado, Double valor) {
        this.idAlquiler = idAlquiler;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_entrega = fecha_entrega;
        this.estado = estado;
        this.valor = valor;
    }

    public Long getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(Long idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vehiculos getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculos vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(LocalDate fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}