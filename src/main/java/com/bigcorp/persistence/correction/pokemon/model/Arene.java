package com.bigcorp.persistence.correction.pokemon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Arene {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private String nom;
	
	private TypeArene type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TypeArene getType() {
		return type;
	}

	public void setType(TypeArene type) {
		this.type = type;
	}


}
