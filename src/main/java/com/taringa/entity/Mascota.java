package com.taringa.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the "APP_MASCOTA" database table.
 * 
 */
@Entity
@Table(name="app_mascota")
public class Mascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@JsonIgnore
	@Column(name="castrado",nullable=true,length = 1)
	@Size(min=1,message="Minimo de 1 caracter")
	private String castrado;

	@Column(name="descripcion",nullable=false,length = 500)
	private String descripcion;

	@Column(name="edad")
	private Integer edad;

	@JsonIgnore
	@Column(name="esterilizada",nullable=true,length = 1)
	@Size(min=1,message="Minimo de 1 caracter")
	private String esterilizada;

	@JsonIgnore
	@Column(name="imagen")
	private byte[] imagen;

	@Column(name="nombre",nullable=true,length = 40)
	@Size(min=1,message="Minimo de 40 caracteres")
	private String nombre;

	@JsonIgnore
	@Column(name="proceso")
	private String proceso;

	@Column(name="raza",nullable=false,length = 30)
	@Size(min=2,message="Minimo de 2 caracteres")
	private String raza;

	@Column(name="sexo",nullable=false,length = 10)
	private String sexo;

	@Column(name="tamano",nullable=true,length = 20)
	private String tamano;

	public Mascota() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCastrado() {
		return this.castrado;
	}

	public void setCastrado(String castrado) {
		this.castrado = castrado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEsterilizada() {
		return this.esterilizada;
	}

	public void setEsterilizada(String esterilizada) {
		this.esterilizada = esterilizada;
	}

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProceso() {
		return this.proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public String getRaza() {
		return this.raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTamano() {
		return this.tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

}