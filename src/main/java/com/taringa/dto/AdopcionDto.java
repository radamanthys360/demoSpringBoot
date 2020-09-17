package com.taringa.dto;

import java.util.Date;
import org.springframework.hateoas.RepresentationModel;

public class AdopcionDto extends RepresentationModel<AdopcionDto>{
	
	private Long id;
	private String estado;
	private Date fecha;
	private MascotaDto idMascota;
	private PersonaDto idPersona;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public MascotaDto getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(MascotaDto idMascota) {
		this.idMascota = idMascota;
	}
	public PersonaDto getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(PersonaDto idPersona) {
		this.idPersona = idPersona;
	}
}
