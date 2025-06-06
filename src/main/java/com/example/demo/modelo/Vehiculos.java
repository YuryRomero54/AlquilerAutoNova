package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Vehiculos")
public class Vehiculos {

	
public Vehiculos() {
		super();
	}

public Vehiculos(long id_Vehiculo, String tipo, String placa, String color, float valorDiario, String imagen,
			String estado) {
		super();
		this.id_Vehiculo = id_Vehiculo;
		this.tipo = tipo;
		this.placa = placa;
		this.color = color;
		this.valorDiario = valorDiario;
		this.imagen = imagen;
		this.estado = estado;
	}



public long getId_Vehiculo() {
	return id_Vehiculo;
}

public void setId_Vehiculo(long id_Vehiculo) {
	this.id_Vehiculo = id_Vehiculo;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public String getPlaca() {
	return placa;
}

public void setPlaca(String placa) {
	this.placa = placa;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public float getValorDiario() {
	return valorDiario;
}

public void setValorDiario(float valorDiario) {
	this.valorDiario = valorDiario;
}

public String getImagen() {
	return imagen;
}

public void setImagen(String imagen) {
	this.imagen = imagen;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}



@Id
@Column(name="id_Vehiculo")
private long  id_Vehiculo;
@Column(name = "Tipo", length = 30, nullable = false)
private String tipo;

@Column(name = "Placa", length = 10, nullable = false, unique = true)
private String placa;

@Column(name = "Color", length = 20, nullable = false)
private String color;

@Column(name = "Valor_Diario", nullable = false)
private float valorDiario;

@Column(name = "Imagen", length = 100)
private String imagen;

@Column(name = "Estado", length = 20, nullable = false)
private String estado;
}
