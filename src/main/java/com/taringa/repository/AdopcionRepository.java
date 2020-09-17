package com.taringa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taringa.entity.Adopcion;

public interface AdopcionRepository <P> extends JpaRepository<Adopcion,Long>{

}
