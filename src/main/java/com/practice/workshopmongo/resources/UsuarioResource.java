package com.practice.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.workshopmongo.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		Usuario maria = new Usuario("1","Maria","maria@gmail.com");
		Usuario alex = new Usuario("2","alex","alex@gmail.com");
		List<Usuario> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
	}
}
