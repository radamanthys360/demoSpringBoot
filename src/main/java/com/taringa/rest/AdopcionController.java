package com.taringa.rest;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.taringa.dto.AdopcionDto;
import com.taringa.entity.Adopcion;
import com.taringa.exception.NotFoundException;
import com.taringa.services.AdopcionServices;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequestMapping("/api/adopcion")
@RestController
public class AdopcionController {
	
	@Autowired
	private AdopcionServices adopcionServices;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@RequestBody AdopcionDto adop) {
		Adopcion guardado = adopcionServices.saveDto(adop);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(guardado.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody AdopcionDto adop) {
		adopcionServices.saveDto(adop);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	//public ResponseEntity<Mascota> listarPorId(@PathVariable("id") Long id) { // forma normal
	public EntityModel<AdopcionDto> listarPorId(@PathVariable("id") Long id) {
		 AdopcionDto dto = adopcionServices.findByIdDto(id);
		 if(dto == null) {
			 throw new NotFoundException("ID NO ENCONTRADO " + id);
		 }
		 //return new ResponseEntity<Mascota>(mascota.get(),HttpStatus.OK); // forma normal
		 dto.add(linkTo(methodOn(AdopcionController.class)
                    .listarPorId(id)).withSelfRel());
		 dto.getIdMascota().add(linkTo(methodOn(MascotaController.class)
                 .listarPorId(dto.getIdMascota().getId())).withSelfRel());
		 dto.getIdPersona().add(linkTo(methodOn(PersonaController.class)
                 .listarPorId(dto.getIdPersona().getId())).withSelfRel());
		 EntityModel<AdopcionDto> model = EntityModel.of(dto);
		 return model;
	}
	
	@GetMapping(value="/pageable",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<AdopcionDto>> listarPageable(Pageable pageable){
		Page<AdopcionDto> listaAdopcion = adopcionServices.findAll(pageable);
		for (final AdopcionDto dto : listaAdopcion) {
			 dto.add(linkTo(methodOn(AdopcionController.class)
	                    .listarPorId(dto.getId())).withSelfRel());
			 dto.getIdMascota().add(linkTo(methodOn(MascotaController.class)
	                 .listarPorId(dto.getIdMascota().getId())).withSelfRel());
			 dto.getIdPersona().add(linkTo(methodOn(PersonaController.class)
	                 .listarPorId(dto.getIdPersona().getId())).withSelfRel());
		}
		return new ResponseEntity<Page<AdopcionDto>>(listaAdopcion,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}") 
	public void eliminar(@PathVariable("id") Long id) {
		adopcionServices.delete(id);
	}

}
