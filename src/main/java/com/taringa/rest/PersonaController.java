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
import com.taringa.entity.Persona;
import com.taringa.exception.NotFoundException;
import com.taringa.services.PersonaServices;

@RequestMapping("/api/personas")
@RestController
public class PersonaController {
	
	@Autowired
	private PersonaServices personaServices;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@RequestBody Persona per) {
		Persona guardado = personaServices.save(per);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(guardado.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody Persona per) {
		personaServices.save(per);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	//public ResponseEntity<Persona> listarPorId(@PathVariable("id") Long id) { // forma normal
	public EntityModel<Persona> listarPorId(@PathVariable("id") Long id) {
		 Optional<Persona> persona = personaServices.findById(id);
		 if(! persona.isPresent()) {
			 throw new NotFoundException("ID NO ENCONTRADO " + id);
		 }
		 //return new ResponseEntity<Persona>(persona.get(),HttpStatus.OK); // forma normal
		 EntityModel<Persona> model = EntityModel.of(persona.get());
		 return model;
	}
	
	@GetMapping(value="/pageable",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Persona>> listarPageable(Pageable pageable){
		return new ResponseEntity<Page<Persona>>(personaServices.findAll(pageable),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}") 
	public void eliminar(@PathVariable("id") Long id) {
		personaServices.delete(id);
	}
	
}
