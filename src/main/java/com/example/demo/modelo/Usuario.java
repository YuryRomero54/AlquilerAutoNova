package com.example.demo.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;

@NamedQuery(name= "Usuario.findByEmailId", query="select u from Usuario u where u.correoUsuario = :correoUsuario")
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "Usuarios")
public class Usuario implements Serializable {

    @Id
    @Column(name = "Id_Usuario")
    private long idUsuario;

    @Column(name = "Nombre_Completo", length = 50, nullable = false)
    private String nombreCompleto;

    @Column(name = "Apellidos", length = 50, nullable = false)
    private String apellidos;

    @Column(name = "Categoria_Licencia", length = 150, nullable = false)
    private String categoriaLicencia;

    @Column(name = "Telefono", length = 20, nullable = false)
    private String telefono;

    @Column(name = "Fecha_Expedicion_licencia", length = 20, nullable = false)
    private LocalDate fechaExpedicionLicencia;

    @Column(name = "Vigencia", length = 20, nullable = false)
    private LocalDate vigencia;

    @Column(name = "Correo_Usuario", length = 30, nullable = false)
    private String correoUsuario;

    @Column(name = "Password", length = 50, nullable = false)
    private String password;

    @Column(name = "Role", length = 50, nullable = false)
    private String role;

    public Usuario() {}

    public Usuario(long idUsuario, String nombreCompleto, String apellidos, String categoriaLicencia,
                   String telefono, LocalDate fechaExpedicionLicencia, LocalDate vigencia,
                   String correoUsuario, String password, String role) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.apellidos = apellidos;
        this.categoriaLicencia = categoriaLicencia;
        this.telefono = telefono;
        this.fechaExpedicionLicencia = fechaExpedicionLicencia;
        this.vigencia = vigencia;
        this.correoUsuario = correoUsuario;
        this.password = password;
        this.role = role;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCategoriaLicencia() {
        return categoriaLicencia;
    }

    public void setCategoriaLicencia(String categoriaLicencia) {
        this.categoriaLicencia = categoriaLicencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaExpedicionLicencia() {
        return fechaExpedicionLicencia;
    }

    public void setFechaExpedicionLicencia(LocalDate fechaExpedicionLicencia) {
        this.fechaExpedicionLicencia = fechaExpedicionLicencia;
    }

    public LocalDate getVigencia() {
        return vigencia;
    }

    public void setVigencia(LocalDate vigencia) {
        this.vigencia = vigencia;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombreCompleto, apellidos, categoriaLicencia,
                telefono, fechaExpedicionLicencia, vigencia, correoUsuario, password, role);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Usuario))
            return false;
        Usuario other = (Usuario) obj;
        return idUsuario == other.idUsuario &&
               Objects.equals(nombreCompleto, other.nombreCompleto) &&
               Objects.equals(apellidos, other.apellidos) &&
               Objects.equals(categoriaLicencia, other.categoriaLicencia) &&
               Objects.equals(telefono, other.telefono) &&
               Objects.equals(fechaExpedicionLicencia, other.fechaExpedicionLicencia) &&
               Objects.equals(vigencia, other.vigencia) &&
               Objects.equals(correoUsuario, other.correoUsuario) &&
               Objects.equals(password, other.password) &&
               Objects.equals(role, other.role);
    }
}




