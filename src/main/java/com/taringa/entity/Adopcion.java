package com.taringa.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the "APP_ADOPCION" database table.
 * 
 */
@Entity
@Table(name="app_adopcion")
public class Adopcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name="estado",nullable=false,length = 50)
	@Size(min=1,message="Minimo de 1 caracter")
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha",nullable=false)
	private Date fecha;

	@OneToOne
	@JoinColumn(name = "idMascota", referencedColumnName = "ID",nullable=false)
	private Mascota idMascota;

	@OneToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "ID",nullable=false)
	private Persona idPersona;

	public Adopcion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Mascota getIdMascota() {
		return this.idMascota;
	}

	public void setIdMascota(Mascota idMascota) {
		this.idMascota = idMascota;
		//idMascota.getAdopciones().add(this);
	}

	public Persona getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}

}