package com.bigcorp.persistence.cours;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersistAndFindBookingMain {

	public static void main(String[] args) {
		// AutoCloseable, pourrait être mis dans un try with resources
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.bigcorp.persistence");
		
		entityManagerFactory.close();
	}

	/**
	 * Sauvegarde l'entité object
	 * 
	 * @param entityManagerFactory
	 * @param object
	 * @return
	 */
	private static void saveBooking(EntityManagerFactory entityManagerFactory, Object object) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(object);
		tx.commit();

		entityManager.close();
	}

}
