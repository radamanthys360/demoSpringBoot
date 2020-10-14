package com.taringa.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	public Boolean findByUsuario(String nombreUsuario) {
		if(personaRepository.findByUsuarioEquals(nombreUsuario).isPresent()) {
			return true;
		}else {
			return false;
		}
	}
	
	public Page<PersonaDto> findAll(Pageable pageable) {
		Page<Persona> listaEntidad = personaRepository.findAll(pageable);
		return listaEntidad.map(objectEntity  -> modelMapper.map(objectEntity, PersonaDto.class));
	}
	
	public Page<PersonaDto> findAllText(String texto,Pageable pageable) {
		Date fecha = null;
		try {
			fecha = new SimpleDateFormat("dd-MM-yyyy").parse(texto);
		} catch (ParseException e) {
		}
		Page<Persona> listaEntidad = personaRepository.findAllText(texto,fecha,pageable);
		return listaEntidad.map(objectEntity  -> modelMapper.map(objectEntity, PersonaDto.class));
	}
	
	@Transactional
	public void delete (Long id) {
		personaRepository.deleteById(id);
	}

}
