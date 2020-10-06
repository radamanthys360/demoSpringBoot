package com.taringa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taringa.entity.Persona;

public interface PersonaRepository <P> extends JpaRepository<Persona,Long>{
	
//    @Query("SELECT t FROM Persona t where t.usuario = :usuario") 
//    Optional<Persona> findByUsuarioEquals(@Param("usuario") String usuario);
	
	Optional<Persona> findByUsuarioEquals(String usuario);
}
