package com.taringa.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.taringa.dto.PersonaDto;
import com.taringa.entity.Persona;
import com.taringa.exception.NotFoundException;
import com.taringa.services.PersonaServices;

@RequestMapping("/api/personas")
@CrossOrigin(origins = "*")
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
	public EntityModel<PersonaDto> listarPorId(@PathVariable("id") Long id) {
		 PersonaDto persona = personaServices.findByIdDto(id);
		 if( persona == null) {
			 throw new NotFoundException("ID NO ENCONTRADO " + id);
		 }
		 //return new ResponseEntity<Persona>(persona.get(),HttpStatus.OK); // forma normal
		 persona.add(linkTo(methodOn(PersonaController.class)
                 .listarPorId(id)).withSelfRel());
		 EntityModel<PersonaDto> model = EntityModel.of(persona);
		 return model;
	}
	
	@GetMapping(value="/pageable",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<PersonaDto>> listarPageable(Pageable pageable){
		Page<PersonaDto> entidadLista = personaServices.findAll(pageable);
		for (final PersonaDto dto : entidadLista) {
			 dto.add(linkTo(methodOn(PersonaController.class)
	                    .listarPorId(dto.getId())).withSelfRel());
		}
		return new ResponseEntity<Page<PersonaDto>>(entidadLista,HttpStatus.OK);
	}
	
	@GetMapping(value="/{texto}/pageable",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<PersonaDto>> buscarPageable(@PathVariable("texto") String texto,
			                                               Pageable pageable){
		Page<PersonaDto> entidadLista = personaServices.findAllText(texto, pageable);
		for (final PersonaDto dto : entidadLista) {
			 dto.add(linkTo(methodOn(PersonaController.class)
	                    .listarPorId(dto.getId())).withSelfRel());
		}
		return new ResponseEntity<Page<PersonaDto>>(entidadLista,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}") 
	public void eliminar(@PathVariable("id") Long id) {
		personaServices.delete(id);
	}
	
	@GetMapping(value="/findByUsuario/{nombreUsuario}/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean  findByUsuario(@PathVariable("nombreUsuario") String nombreUsuario,@PathVariable("id") Long id){
		return personaServices.findByUsuario(nombreUsuario,id);
	}
	
}
