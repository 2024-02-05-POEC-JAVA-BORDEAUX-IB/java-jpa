package com.bigcorp.persistence.correction.pokemon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EspecePokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private String nom;
	
	private Integer pointsDeVieInit;

	@Enumerated(EnumType.STRING)
	private TypePokemon type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ATTAQUE_ID")
	private Attaque attaqueBase;

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

	public Integer getPointsDeVieInit() {
		return pointsDeVieInit;
	}

	public void setPointsDeVieInit(Integer pointsDeVieInit) {
		this.pointsDeVieInit = pointsDeVieInit;
	}

	public Attaque getAttaqueBase() {
		return attaqueBase;
	}

	public void setAttaqueBase(Attaque attaqueBase) {
		this.attaqueBase = attaqueBase;
	}

	public TypePokemon getType() {
		return type;
	}

	public void setType(TypePokemon type) {
		this.type = type;
	}
}
