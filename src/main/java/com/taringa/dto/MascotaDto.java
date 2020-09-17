package com.taringa.dto;

import org.springframework.hateoas.RepresentationModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class MascotaDto extends RepresentationModel<MascotaDto>{
	
	private Long id;
	@JsonIgnore
	private String castrado;
	private String descripcion;
	private Integer edad;
	@JsonIgnore
	private String esterilizada;
	@JsonIgnore
	private byte[] imagen;
	private String nombre;
	@JsonIgnore
	private String proceso;
	private String raza;
	private String sexo;
	private String tamano;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCastrado() {
		return castrado;
	}
	public void setCastrado(String castrado) {
		this.castrado = castrado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getEsterilizada() {
		return esterilizada;
	}
	public void setEsterilizada(String esterilizada) {
		this.esterilizada = esterilizada;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProceso() {
		return proceso;
	}
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTamano() {
		return tamano;
	}
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

}
