package com.bigcorp.persistence.cours.dao;

import java.util.List;
import java.util.Objects;

import com.bigcorp.persistence.cours.model.Booking;
import com.bigcorp.persistence.cours.util.PersistenceFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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

	public String getNameWithNativeSQL(Long id) {
		EntityManager em = PersistenceFactory.INSTANCE.getEntityManager();
		Query sqlQuery = em.createNativeQuery("SELECT NAME FROM BOOKING WHERE ID = " + id);
		List<?> result = sqlQuery.getResultList();
		if (result.isEmpty()) {
			return null;
		}
		// else
		return Objects.toString(result.get(0));
	}

	public List<Booking> getBookingFromName(String name) {
		EntityManager em = PersistenceFactory.INSTANCE.getEntityManager();
		TypedQuery<Booking> query = em.createQuery(
				"select b "
				+ " from Booking b "
				+ " where b.name = :paramName ", Booking.class);
		query.setParameter("paramName", name);
		List<Booking> resultList = query.getResultList();
		em.close();
		return resultList;
	}

	public List<Booking> getBookingFromNameLike(String name) {
		EntityManager em = PersistenceFactory.INSTANCE.getEntityManager();
		TypedQuery<Booking> query = em.createQuery(
				"select b "
				+ " from Booking b "
				+ " where upper(b.name) like upper(concat('%',:paramName,'%')) ", Booking.class);
		query.setParameter("paramName",  name );
		List<Booking> resultList = query.getResultList();
		em.close();
		return resultList;
	}
	
	

}
