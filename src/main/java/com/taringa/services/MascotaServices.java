package com.taringa.services;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.taringa.dto.MascotaDto;
import com.taringa.entity.Mascota;
import com.taringa.repository.MascotaRepository;

@Service
public class MascotaServices {
	
	@Autowired
	private MascotaRepository<Mascota> mascotaRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	@Transactional
	public Mascota save(Mascota mascota) {
		return mascotaRepository.save(mascota);
	}
	
	@Transactional
	public MascotaDto findById(Long id) {
		Optional<Mascota> entidad = mascotaRepository.findById(id);
		if(entidad.isPresent()) {
			return modelMapper.map(entidad.get(), MascotaDto.class);
		}else {
			return null;
		}
	}
	
	public Page<MascotaDto> findAll(Pageable pageable) {
		Page<Mascota> listaEntidad = mascotaRepository.findAll(pageable);
		return listaEntidad.map(objectEntity  -> modelMapper.map(objectEntity, MascotaDto.class));
	}
	
	@Transactional
	public void delete (Long id) {
		mascotaRepository.deleteById(id);
	}

}
