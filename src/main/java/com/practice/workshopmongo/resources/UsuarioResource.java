package com.practice.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.practice.workshopmongo.dto.UsuarioDTO;
import com.practice.workshopmongo.entities.Usuario;
import com.practice.workshopmongo.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
		
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> listObj = service.findAll();
		List<UsuarioDTO> listDTO= listObj.stream().map(u -> new UsuarioDTO(u)).collect(Collectors.toList());	
		return ResponseEntity.ok().body(listDTO);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable String id) {
		UsuarioDTO dto = new UsuarioDTO(service.findById(id));
		return ResponseEntity.ok().body(dto);
	}
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UsuarioDTO objDTO) {
		Usuario obj = UsuarioDTO.fromDTO(objDTO); 
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> insert(@RequestBody UsuarioDTO objDTO, @PathVariable String id) {
		Usuario obj = UsuarioDTO.fromDTO(objDTO); 
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
