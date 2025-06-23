package com.example.demo.modelo;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Alquiler")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_alquiler;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculos vehiculo;

    private LocalDate fecha_inicio;
    private LocalDate fecha_entrega;
    private String estado;
    private Double valor;

    public Alquiler() {
    	
    }

    public Alquiler(Long id_alquiler, Usuario usuario, Vehiculos vehiculo,
                    LocalDate fecha_inicio, LocalDate fecha_entrega,
                    String estado, Double valor) {
        this.id_alquiler = id_alquiler;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_entrega = fecha_entrega;
        this.estado = estado;
        this.valor = valor;
    }

    public Long getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(Long id_alquiler) {
        this.id_alquiler = id_alquiler;
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