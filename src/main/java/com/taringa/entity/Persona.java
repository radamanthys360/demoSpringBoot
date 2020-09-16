package com.taringa.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * The persistent class for the "APP_PERSONA" database table.
 * 
 */
@Entity
@Table(name="app_persona")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name="clave",nullable=false,length = 100)
	@Size(min=6,message="Minimo de 6 caracteres")
	private String clave;

	@Column(name="direccion",nullable=false,length = 100)
	@Size(min=1,message="Minimo de 1 caracter")
	private String direccion;

	@Column(name="documento_identidad",nullable=false,length = 12)
	@Size(min=12,message="Minimo de 12 caracteres")
	private String documentoIdentidad;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd-MM-yyyy")
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="nombre",nullable=false,length = 70)
	@Size(min=3,message="Minimo de 3 caracteres")
	private String nombre;

	@Column(name="sexo",nullable=false,length = 10)
	private String sexo;

	@Column(name="usuario",nullable=false,length = 50)
	@Size(min=3,message="Minimo de 3 caracteres")
	private String usuario;

	public Persona() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDocumentoIdentidad() {
		return this.documentoIdentidad;
	}

	public void setDocumentoIdentidad(String documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}