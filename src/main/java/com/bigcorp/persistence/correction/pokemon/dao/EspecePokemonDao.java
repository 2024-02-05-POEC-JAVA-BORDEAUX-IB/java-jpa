package com.bigcorp.persistence.correction.pokemon.dao;

import com.bigcorp.persistence.correction.pokemon.model.EspecePokemon;
import com.bigcorp.persistence.cours.util.PersistenceFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

/**
 * Data Access Object pour l'entité EspecePokemon
 */
public class EspecePokemonDao {


	/**
	 * Sauvegarde une especePokemon
	 * 
	 * @param especePokemon
	 * @return l'especePokemon sauvegardé. A utiliser pour récupérer des informations de
	 *         la base de données.
	 */
	public EspecePokemon save(EspecePokemon especePokemon) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			EspecePokemon savedEspecePokemon = entityManager.merge(especePokemon);
			transaction.commit();
			return savedEspecePokemon;
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
