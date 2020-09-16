package com.taringa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taringa.entity.Persona;
import com.taringa.repository.PersonaRepository;

@Service
public class PersonaServices {
	
	@Autowired
	private PersonaRepository<Persona> personaRepository;
	
	@Transactional
	public Persona save(Persona persona) {
		return personaRepository.save(persona);
	}
	
	public Optional<Persona> findById(Long id) {
		return personaRepository.findById(id);
	}
	
	public Page<Persona> findAll(Pageable pageable) {
		return personaRepository.findAll(pageable);
	}
	
	@Transactional
	public void delete (Long id) {
		personaRepository.deleteById(id);
	}

}
