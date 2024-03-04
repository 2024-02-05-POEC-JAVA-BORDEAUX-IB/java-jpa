package com.bigcorp.persistence.cours;

import com.bigcorp.persistence.cours.model.Booking;
import com.bigcorp.persistence.cours.util.PersistenceFactory;

import jakarta.persistence.EntityManager;

public class BookingDao {
	
	public Booking findById(Long id) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		Booking booking = entityManager.find(Booking.class, id);
		return booking;
	}

}
