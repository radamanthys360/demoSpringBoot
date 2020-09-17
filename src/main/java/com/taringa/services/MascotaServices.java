package com.taringa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.taringa.entity.Mascota;
import com.taringa.repository.MascotaRepository;

@Service
public class MascotaServices {
	
	@Autowired
	private MascotaRepository<Mascota> mascotaRepository;
	
	@Transactional
	public Mascota save(Mascota mascota) {
		return mascotaRepository.save(mascota);
	}
	
	public Optional<Mascota> findById(Long id) {
		return mascotaRepository.findById(id);
	}
	
	public Page<Mascota> findAll(Pageable pageable) {
		return mascotaRepository.findAll(pageable);
	}
	
	@Transactional
	public void delete (Long id) {
		mascotaRepository.deleteById(id);
	}

}
