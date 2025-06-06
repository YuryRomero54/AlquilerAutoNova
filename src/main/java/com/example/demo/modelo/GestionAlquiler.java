package com.example.demo.modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "GestionAlquiler")
public class GestionAlquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_gestion;

    @ManyToOne
    @JoinColumn(name = "id_administrador", nullable = false)
    private Admin administrador;

    @ManyToOne
    @JoinColumn(name = "id_alquiler", nullable = false)
    private Alquiler alquiler;

    private LocalDate fecha_gestion;
    private String observaciones;

    public GestionAlquiler() {}

    public GestionAlquiler(Long id_gestion, Admin administrador, Alquiler alquiler,
                           LocalDate fecha_gestion, String observaciones) {
        this.id_gestion = id_gestion;
        this.administrador = administrador;
        this.alquiler = alquiler;
        this.fecha_gestion = fecha_gestion;
        this.observaciones = observaciones;
    }


    public Long getId_gestion() {
        return id_gestion;
    }

    public void setId_gestion(Long id_gestion) {
        this.id_gestion = id_gestion;
    }

    public Admin getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Admin administrador) {
        this.administrador = administrador;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public LocalDate getFecha_gestion() {
        return fecha_gestion;
    }

    public void setFecha_gestion(LocalDate fecha_gestion) {
        this.fecha_gestion = fecha_gestion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
