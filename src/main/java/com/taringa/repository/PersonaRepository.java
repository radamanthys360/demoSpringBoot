package com.taringa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taringa.entity.Persona;

public interface PersonaRepository <P> extends JpaRepository<Persona,Long>{

}
