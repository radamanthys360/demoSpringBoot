package com.taringa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taringa.entity.Mascota;

public interface MascotaRepository <P> extends JpaRepository<Mascota,Long>{

}
