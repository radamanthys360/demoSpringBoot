package com.taringa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the "APP_MASCOTA" database table.
 * 
 */
@Entity
@Table(name="app_mascota")
public class Mascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="castrado")
	private String castrado;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="edad")
	private Integer edad;

	@Column(name="esterilizada")
	private String esterilizado;

	@Column(name="imagen")
	private byte[] imagen;

	@Column(name="nombre")
	private String nombre;

	@Column(name="proceso")
	private String proceso;

	@Column(name="raza")
	private String raza;

	@Column(name="sexo")
	private String sexo;

	@Column(name="tamano")
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

	public String getEsterilizado() {
		return this.esterilizado;
	}

	public void setEsterilizado(String esterilizado) {
		this.esterilizado = esterilizado;
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