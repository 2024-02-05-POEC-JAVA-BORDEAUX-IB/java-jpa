package com.bigcorp.persistence.correction.pokemon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Attaque {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private String nom;
	
	@Enumerated(EnumType.STRING)
	private TypePokemon type;

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

	public TypePokemon getType() {
		return type;
	}

	public void setType(TypePokemon type) {
		this.type = type;
	}
	
	

}
