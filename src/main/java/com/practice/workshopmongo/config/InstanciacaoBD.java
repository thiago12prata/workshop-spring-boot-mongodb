package com.practice.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.practice.workshopmongo.dto.AutorDTO;
import com.practice.workshopmongo.entities.Post;
import com.practice.workshopmongo.entities.Usuario;
import com.practice.workshopmongo.repositories.PostRepository;
import com.practice.workshopmongo.repositories.UsuarioRepository;

@Configuration
public class InstanciacaoBD implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		usuarioRepository.deleteAll();
		postRepository.deleteAll();
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario u2= new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario u3 = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2,u3));
		
		Post p1 = new Post(null, Instant.parse("2018-03-21T19:53:07Z"), "Patiu Viagem","Vou para São paulo", new AutorDTO(u1));
		Post p2 = new Post(null, Instant.parse("2018-03-23T19:53:07Z"), "Bom dia","Acordei feliz!", new AutorDTO(u1));		
		
		postRepository.saveAll(Arrays.asList(p1,p2));
		
		u1.getPosts().addAll(Arrays.asList(p1,p2));
		usuarioRepository.save(u1);
	}	
}
