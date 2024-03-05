package com.bigcorp.persistence.cours.dao;

import com.bigcorp.persistence.cours.model.Booking;
import com.bigcorp.persistence.cours.util.PersistenceFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class BookingDao {

	public Booking findById(Long id) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		Booking booking = entityManager.find(Booking.class, id);
		entityManager.close();
		return booking;
	}

	public Booking save(Booking booking) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Booking savedBooking = entityManager.merge(booking);
		transaction.commit();
		entityManager.close();
		return savedBooking;
	}

	public Booking saveComplexe(Booking booking) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Booking savedBooking = entityManager.merge(booking);
			transaction.commit();
			return savedBooking;
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
