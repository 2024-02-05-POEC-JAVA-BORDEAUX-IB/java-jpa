package com.bigcorp.persistence.correction.pokemon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dresseur {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private String nom;
	
	private Integer age;
	
	private Integer nombreDePieces;

	@Enumerated(EnumType.STRING)
	private Sexe sexe;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getNombreDePieces() {
		return nombreDePieces;
	}

	public void setNombreDePieces(Integer nombreDePieces) {
		this.nombreDePieces = nombreDePieces;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	@Override
	public String toString() {
		return "Dresseur [id=" + id + ", nom=" + nom + "]";
	}
	
}
