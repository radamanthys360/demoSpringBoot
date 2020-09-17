package com.taringa.services;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.taringa.dto.PersonaDto;
import com.taringa.entity.Persona;
import com.taringa.repository.PersonaRepository;

@Service
public class PersonaServices {
	
	@Autowired
	private PersonaRepository<Persona> personaRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	@Transactional
	public Persona save(Persona persona) {
		return personaRepository.save(persona);
	}
	
	public PersonaDto findByIdDto(Long id) {
		Optional<Persona> entidad = personaRepository.findById(id);
		if(entidad.isPresent()) {
			return modelMapper.map(entidad.get(), PersonaDto.class);
		}else {
			return null;
		}
	}
	
	public Page<PersonaDto> findAll(Pageable pageable) {
		Page<Persona> listaEntidad = personaRepository.findAll(pageable);
		return listaEntidad.map(objectEntity  -> modelMapper.map(objectEntity, PersonaDto.class));
	}
	
	@Transactional
	public void delete (Long id) {
		personaRepository.deleteById(id);
	}

}
