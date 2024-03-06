package com.bigcorp.persistence.correction.pokemon.dao;

import com.bigcorp.persistence.correction.pokemon.model.Attaque;
import com.bigcorp.persistence.cours.util.PersistenceFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

/**
 * Data Access Object pour l'entité Attaque
 */
public class AttaqueDao {


	/**
	 * Sauvegarde une attaque
	 * 
	 * @param attaque
	 * @return l'attaque sauvegardée. A utiliser pour récupérer des informations de
	 *         la base de données.
	 */
	public Attaque save(Attaque attaque) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Attaque savedAttaque = entityManager.merge(attaque);
			transaction.commit();
			return savedAttaque;
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
