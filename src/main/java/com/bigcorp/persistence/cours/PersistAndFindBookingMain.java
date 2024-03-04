package com.bigcorp.persistence.cours;

import com.bigcorp.persistence.cours.model.Booking;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersistAndFindBookingMain {

	public static void main(String[] args) {
		// AutoCloseable, pourrait être mis dans un try with resources
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.bigcorp.persistence");
		
		
		Booking booking = new Booking();
		booking.setName("Réservation des stagiaires");
		saveBooking(entityManagerFactory, booking);

		Booking booking2 = new Booking();
		booking2.setName("Réservation Monsieur Poulet");
		saveBooking(entityManagerFactory, booking2);
		
		//Récupération d'un entityManager
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//Récupération du booking avec l'id du booking précédemment sauvegardé
		Booking bookingAvecId3 = entityManager.find(Booking.class , booking.getId());
		System.out.println("J'ai trouvé le booking : " + bookingAvecId3.getName());
		
		//Fermeture de l'entityManager
		entityManager.close();
		
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
