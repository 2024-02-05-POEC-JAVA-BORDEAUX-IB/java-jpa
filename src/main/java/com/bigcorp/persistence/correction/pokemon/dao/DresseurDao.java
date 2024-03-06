package com.bigcorp.persistence.correction.pokemon.dao;

import java.util.List;

import com.bigcorp.persistence.correction.pokemon.model.Dresseur;
import com.bigcorp.persistence.cours.util.PersistenceFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

/**
 * Data Access Object pour l'entité Dresseur
 */
public class DresseurDao {

	/**
	 * Récupère un dresseur par son id, ou null, si aucun n'existe en base.
	 * 
	 * @param id
	 * @return
	 */
	public Dresseur findById(Long id) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		Dresseur dresseur = entityManager.find(Dresseur.class, id);
		entityManager.close();
		return dresseur;
	}

	/**
	 * Sauvegarde un dresseur
	 * 
	 * @param dresseur
	 * @return le dresseur sauvegardé. A utiliser pour récupérer des informations de
	 *         la base de données.
	 */
	public Dresseur save(Dresseur dresseur) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Dresseur savedDresseur = entityManager.merge(dresseur);
			transaction.commit();
			return savedDresseur;
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
	 * Supprimer le dresseur avec l'id passé en paramètre. Ne fait rien si aucun
	 * dresseur ne correspond en base.
	 * 
	 * @param id
	 */
	public void deleteDresseur(Long id) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Query query = entityManager.createQuery("delete Dresseur p where p.id = :id ");
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

	/**
	 * Récupère tous les dresseurs avec le nom passé en paramètre
	 * 
	 * @param nom
	 * @return
	 */
	public List<Dresseur> getFromName(String nom) {
		EntityManager em = PersistenceFactory.INSTANCE.getEntityManager();
		TypedQuery<Dresseur> query = em.createQuery("select d " + " from Dresseur d" + " where d.nom = :paramName ",
				Dresseur.class);
		query.setParameter("paramName", nom);
		List<Dresseur> resultList = query.getResultList();
		em.close();
		return resultList;
	}

	/**
	 * Récupère tous les dresseurs dont le nom contient l'argument nom
	 * 
	 * @param nom
	 * @return
	 */
	public List<Dresseur> getFromNameLike(String nom) {
		EntityManager em = PersistenceFactory.INSTANCE.getEntityManager();
		TypedQuery<Dresseur> query = em.createQuery(
				"select d " + " from Dresseur d " + " where upper(d.nom) like upper(concat('%',:paramName,'%')) ",
				Dresseur.class);
		query.setParameter("paramName", nom);
		List<Dresseur> resultList = query.getResultList();
		em.close();
		return resultList;
	}

}
