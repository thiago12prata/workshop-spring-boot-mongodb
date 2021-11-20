package com.practice.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.workshopmongo.entities.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

	
}
