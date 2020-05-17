package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	

	
	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer C_usuario;
	
	@Column(name="nombre")
	@Size(min=5 ,max=15,message="El campo nombre tiene que minimo 8 o 15 maximo")
	private String Nombre;
	
	@Column(name="apellido")
	@Size(min=5 ,max=15)
	private String Apellido;
	
	@Column(name="carnet")
	@NotNull(message="El campo carnet no puede estar vacio")
	@Min(message="El campo carrera tiene que tener maximo 10 caracteres ",value=5)
	private Integer carnet;
	
	@Column(name="carrera")
	@Size(message="El campo carrera tiene que tener minimo 8 caracteres o 100 caracteres ",min=8 ,max=100)
	private String carrera;
	
	public Estudiante() {}

	public Estudiante(String nombre, String apellido, Integer carnet, String carrera) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		this.carnet = carnet;
		this.carrera = carrera;
	}

	public Integer getC_usuario() {
		return C_usuario;
	}

	public void setC_usuario(Integer c_usuario) {
		C_usuario = c_usuario;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public Integer getCarnet() {
		return carnet;
	}

	public void setCarnet(Integer carnet) {
		this.carnet = carnet;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	
	
	
}
