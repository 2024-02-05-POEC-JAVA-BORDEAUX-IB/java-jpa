package com.bigcorp.persistence.correction.pokemon.dao;

import java.util.List;

import com.bigcorp.persistence.correction.pokemon.model.Pokemon;
import com.bigcorp.persistence.cours.util.PersistenceFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

/**
 * Data Access Object pour l'entité Pokemon
 */
public class PokemonDao {

	/**
	 * Renvoie tous les pokemons
	 * 
	 * @return
	 */
	public List<Pokemon> findAll() {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		TypedQuery<Pokemon> query = entityManager.createQuery("select p " + " from Pokemon p ", Pokemon.class);
		List<Pokemon> pokemons = query.getResultList();
		entityManager.close();
		return pokemons;
	}

	/**
	 * Récupère un pokemon par son id, ou null, si aucun n'existe en base.
	 * 
	 * @param id
	 * @return
	 */
	public Pokemon findById(Long id) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		Pokemon pokemon = entityManager.find(Pokemon.class, id);
		entityManager.close();
		return pokemon;
	}

	/**
	 * Sauvegarde un pokemon
	 * 
	 * @param pokemon
	 * @return le pokemon sauvegardé. A utiliser pour récupérer des informations de
	 *         la base de données.
	 */
	public Pokemon save(Pokemon pokemon) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Pokemon savedPokemon = entityManager.merge(pokemon);
			transaction.commit();
			return savedPokemon;
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		} finally {
			entityManager.close();
		}
	}

	/**
	 * Supprimer le pokemon avec l'id passé en paramètre.
	 * Ne fait rien si aucun pokemon ne correspond en base.
	 * @param id
	 */
	public void deletePokemon(Long id) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Query query = entityManager.createQuery("delete Pokemon p where p.id = :id ");
			query.setParameter("id", id);
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		} finally {
			entityManager.close();
		}

	}

}
