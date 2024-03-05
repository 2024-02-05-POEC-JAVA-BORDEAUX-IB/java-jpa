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
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Booking booking = new Booking();
		booking.setName("Réservation des stagiaires");

		// Création de la transaction
		EntityTransaction transaction = entityManager.getTransaction();

		// Démarrage de la transaction
		transaction.begin();

		// Sauvegarde de booking en base
		booking.setName("Salut");
		entityManager.merge(booking);

		// Commit de la transaction
		transaction.commit();

		Booking booking2 = new Booking();
		booking2.setName("Réservation Monsieur Poulet");

		// Récupération du booking avec l'id du booking précédemment sauvegardé
//		Booking bookingQuiVientDeLaBase = entityManager.find(Booking.class , booking.getId());
//		System.out.println("J'ai trouvé le booking : " + bookingQuiVientDeLaBase.getName());

		// Fermeture de l'entityManager
		entityManager.close();

		entityManagerFactory.close();
	}

	public void updateNoteBooking(Long idBooking, Integer note) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.bigcorp.persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Booking booking = entityManager.find(Booking.class, idBooking);
		if (booking == null) {
			return;
		} else {
			booking.setNote(note);

			EntityTransaction transaction = entityManager.getTransaction();

			transaction.begin();
			entityManager.merge(booking);
			transaction.commit();
		}
		entityManager.close();
		entityManagerFactory.close();

	}

}
