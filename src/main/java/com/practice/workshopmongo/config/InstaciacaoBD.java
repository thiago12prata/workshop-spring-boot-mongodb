package com.practice.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.practice.workshopmongo.entities.Usuario;
import com.practice.workshopmongo.repositories.UsuarioRepository;

@Configuration
public class InstaciacaoBD implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		usuarioRepository.deleteAll();
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario u2= new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario u3 = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2,u3));
	}	
}
