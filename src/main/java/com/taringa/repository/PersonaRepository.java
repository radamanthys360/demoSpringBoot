package com.taringa.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.taringa.entity.Persona;

public interface PersonaRepository <P> extends JpaRepository<Persona,Long>{
	
//    @Query("SELECT t FROM Persona t where t.usuario = :usuario") 
//    Optional<Persona> findByUsuarioEquals(@Param("usuario") String usuario);
	
	Optional<Persona> findByUsuarioEquals(String usuario);
	
    @Query(value = "select per from Persona per where per.direccion like %:texto% or per.documentoIdentidad like %:texto% or "
  		     + "per.fechaNacimiento = :fecha or per.nombre like %:texto% or per.sexo like %:texto% "
  		     + " or per.usuario like %:texto%")
    Page<Persona> findAllText(@Param("texto") String texto,@Param("fecha") Date fecha, Pageable pageable);
}
