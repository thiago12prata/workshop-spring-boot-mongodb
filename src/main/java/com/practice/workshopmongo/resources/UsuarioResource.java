package com.practice.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
