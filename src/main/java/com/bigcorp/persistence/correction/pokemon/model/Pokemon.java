package com.bigcorp.persistence.correction.pokemon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private String nom;

	private Integer niveau;

	private Integer pointsDeVie;

	private Integer pointsDExperience;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ESPECE_POKEMON_ID")
	private EspecePokemon espece;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ATTAQUE_ID")
	private Attaque attaque;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DRESSEUR_ID")
	private Dresseur dresseur;
	
	public Pokemon() {
		
	}

	public Pokemon(EspecePokemon espece) {
		this.espece = espece;
		this.attaque = espece.getAttaqueBase();
		this.pointsDeVie = espece.getPointsDeVieInit();
		this.niveau = 1;
		this.pointsDExperience = 0;
	}

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

	public Integer getNiveau() {
		return niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	public Integer getPointsDeVie() {
		return pointsDeVie;
	}

	public void setPointsDeVie(Integer pointsDeVie) {
		this.pointsDeVie = pointsDeVie;
	}

	public Integer getPointsDExperience() {
		return pointsDExperience;
	}

	public void setPointsDExperience(Integer pointsDExperience) {
		this.pointsDExperience = pointsDExperience;
	}

	public EspecePokemon getEspece() {
		return espece;
	}

	public void setEspece(EspecePokemon espece) {
		this.espece = espece;
	}

	public Attaque getAttaque() {
		return attaque;
	}

	public void setAttaque(Attaque attaque) {
		this.attaque = attaque;
	}

	public Dresseur getDresseur() {
		return dresseur;
	}

	public void setDresseur(Dresseur dresseur) {
		this.dresseur = dresseur;
	}


}
