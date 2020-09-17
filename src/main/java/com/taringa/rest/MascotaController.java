package com.taringa.rest;

import java.net.URI;
import java.util.Optional;

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

import com.taringa.entity.Mascota;
import com.taringa.exception.NotFoundException;
import com.taringa.services.MascotaServices;

@RequestMapping("/api/mascotas")
@RestController
public class MascotaController {
	
	@Autowired
	private MascotaServices mascotaServices;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@RequestBody Mascota mas) {
		Mascota guardado = mascotaServices.save(mas);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(guardado.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody Mascota mas) {
		mascotaServices.save(mas);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	//public ResponseEntity<Mascota> listarPorId(@PathVariable("id") Long id) { // forma normal
	public EntityModel<Mascota> listarPorId(@PathVariable("id") Long id) {
		 Optional<Mascota> mascota = mascotaServices.findById(id);
		 if(! mascota.isPresent()) {
			 throw new NotFoundException("ID NO ENCONTRADO " + id);
		 }
		 //return new ResponseEntity<Mascota>(mascota.get(),HttpStatus.OK); // forma normal
		 EntityModel<Mascota> model = EntityModel.of(mascota.get());
		 return model;
	}
	
	@GetMapping(value="/pageable",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Mascota>> listarPageable(Pageable pageable){
		return new ResponseEntity<Page<Mascota>>(mascotaServices.findAll(pageable),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}") 
	public void eliminar(@PathVariable("id") Long id) {
		mascotaServices.delete(id);
	}

}
