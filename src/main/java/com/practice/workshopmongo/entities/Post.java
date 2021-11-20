package com.practice.workshopmongo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.practice.workshopmongo.dto.AutorDTO;

@Document
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Instant data;
	private String titulo;
	private String corpo;
	
	private AutorDTO autor;
	
	public Post() {
	}
	public Post(String id, Instant data, String titulo, String corpo,AutorDTO autor) {
		super();
		this.id = id;
		this.data = data;
		this.titulo = titulo;
		this.corpo = corpo;
		this.autor = autor;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Instant getData() {
		return data;
	}
	public void setData(Instant data) {
		this.data = data;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCorpo() {
		return corpo;
	}
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	public AutorDTO getAutor() {
		return autor;
	}
	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
}
