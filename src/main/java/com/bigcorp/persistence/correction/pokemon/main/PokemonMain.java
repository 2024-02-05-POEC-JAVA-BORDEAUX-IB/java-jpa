package com.bigcorp.persistence.correction.pokemon.main;

import java.util.List;

import com.bigcorp.persistence.correction.pokemon.dao.AttaqueDao;
import com.bigcorp.persistence.correction.pokemon.dao.DresseurDao;
import com.bigcorp.persistence.correction.pokemon.dao.EspecePokemonDao;
import com.bigcorp.persistence.correction.pokemon.dao.PokemonDao;
import com.bigcorp.persistence.correction.pokemon.model.Attaque;
import com.bigcorp.persistence.correction.pokemon.model.Dresseur;
import com.bigcorp.persistence.correction.pokemon.model.EspecePokemon;
import com.bigcorp.persistence.correction.pokemon.model.Pokemon;
import com.bigcorp.persistence.correction.pokemon.model.Sexe;
import com.bigcorp.persistence.correction.pokemon.model.TypePokemon;

public class PokemonMain {

	public static void main(String[] args) {
		//Création des DAOs
		AttaqueDao attaqueDao = new AttaqueDao();
		PokemonDao pokemonDao = new PokemonDao();
		EspecePokemonDao especePokemonDao = new EspecePokemonDao();
		DresseurDao dresseurDao = new DresseurDao();
		
		
		//Création du dresseur Sacha1
		System.out.println("\r\n Dresseur 1");
		Dresseur sacha1 = new Dresseur();
		sacha1.setAge(15);
		sacha1.setNom("Sacha1");
		sacha1.setNombreDePieces(400);
		sacha1.setSexe(Sexe.MASCULIN);
		sacha1 = dresseurDao.save(sacha1);
		
		//Création du dresseur Sacha2
		System.out.println("\r\n Dresseur 2");
		Dresseur sacha2 = new Dresseur();
		sacha2.setAge(15);
		sacha2.setNom("Sacha2");
		sacha2.setNombreDePieces(200);
		sacha2.setSexe(Sexe.MASCULIN);
		sacha2 = dresseurDao.save(sacha2);
		
		//Création d'une attaque
		System.out.println("\r\n Attaque");
		Attaque plouf = new Attaque();
		plouf.setNom("plouf");
		plouf.setType(TypePokemon.EAU);
		plouf = attaqueDao.save(plouf);
		
		
		//Création d'une espèce de Pokemon
		System.out.println("\r\n Espece");
		EspecePokemon carapuce = new EspecePokemon();
		carapuce.setNom("Carapuce");
		carapuce.setPointsDeVieInit(100);
		carapuce.setAttaqueBase(plouf);
		carapuce = especePokemonDao.save(carapuce);
		
		
		//Création d'un Pokémon, en le rattachant à l'espèce et l'attaque
		System.out.println("\r\n Pokemon");
		Pokemon monPremierPokemon = new Pokemon(carapuce);
		monPremierPokemon.setDresseur(sacha1);
		monPremierPokemon.setNom("Mon premier Pokémon");
		monPremierPokemon = pokemonDao.save(monPremierPokemon);
		
		
		//Affichage des dresseurs
		System.out.println("\r\n Affichage dresseurs");
		List<Dresseur> dresseurs = dresseurDao.getFromNameLike("sacha");
		for (Dresseur dresseur : dresseurs) {
			System.out.println(dresseur);
		}
		
		//Suppression Pokemon
		System.out.println("\r\n Suppression Pokemon");
		pokemonDao.deletePokemon(monPremierPokemon.getId());
		
	}
	
}
