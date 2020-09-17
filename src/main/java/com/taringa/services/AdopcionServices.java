package com.taringa.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taringa.dto.AdopcionDto;
import com.taringa.entity.Adopcion;
import com.taringa.repository.AdopcionRepository;

@Service
public class AdopcionServices {
	
	@Autowired
	private AdopcionRepository<Adopcion> adopcionRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	@Transactional
	public Adopcion saveDto(AdopcionDto adopcion) {
		Adopcion entity = modelMapper.map(adopcion, Adopcion.class);
		return adopcionRepository.save(entity);
	}
	
	public AdopcionDto findByIdDto(Long id) {
		Optional<Adopcion> adopcion = adopcionRepository.findById(id);
		if(adopcion.isPresent()) {
			return modelMapper.map(adopcion.get(), AdopcionDto.class);
		}else {
			return null;
		}
	}
	
	public Page<AdopcionDto> findAll(Pageable pageable) {
		Page<Adopcion> listaEntidad = adopcionRepository.findAll(pageable);
		return listaEntidad.map(objectEntity  -> modelMapper.map(objectEntity, AdopcionDto.class));
	}
	
	@Transactional
	public void delete (Long id) {
		adopcionRepository.deleteById(id);
	}

}
