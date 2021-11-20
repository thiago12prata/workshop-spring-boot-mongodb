package com.practice.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.workshopmongo.entities.Usuario;
import com.practice.workshopmongo.repositories.UsuarioRepository;
import com.practice.workshopmongo.services.exception.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll() {
		return repository.findAll();
	}
	public Usuario findById(String id) {
		 Optional<Usuario> obj = repository.findById(id);
		 return obj.orElseThrow(() -> new ResourceNotFoundException("O objeto com a id: "+ id+" não foi encontrado"));
	}
	public Usuario insert(Usuario obj) {
		return repository.insert(obj); 
	}
	public void delete(String id) {
		findById(id);
		repository.deleteById(id); 
	}
	public Usuario update(Usuario obj) {
		Usuario newObj = findById(obj.getId());
		atualizarDados(newObj, obj);
		return repository.save(newObj);		
	}
	private void atualizarDados(Usuario newObj, Usuario obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setNome(obj.getNome());
	}
}
