package com.practice.workshopmongo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.practice.workshopmongo.entities.Post;
import com.practice.workshopmongo.entities.Usuario;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String email;
	
	
	private List<Post> posts = new ArrayList<>();

	public UsuarioDTO() {

	}
	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		posts = obj.getPosts();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Post> getPosts() {
		return posts;
	}
	
	public static Usuario fromDTO(UsuarioDTO objDTO) {
		return new Usuario(objDTO.getId(),objDTO.nome, objDTO.getEmail());
	}
}
