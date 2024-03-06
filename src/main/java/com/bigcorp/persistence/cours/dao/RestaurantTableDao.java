package com.bigcorp.persistence.cours.dao;

import java.util.List;

import com.bigcorp.persistence.cours.model.OrderFormateur;
import com.bigcorp.persistence.cours.model.RestaurantTable;
import com.bigcorp.persistence.cours.util.PersistenceFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class RestaurantTableDao {

	public RestaurantTable save(RestaurantTable restaurantTable) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		RestaurantTable savedOrder = entityManager.merge(restaurantTable);
		transaction.commit();
		entityManager.close();
		return savedOrder;
	}
	
	public List<RestaurantTable> findByNameWithBookings(String name) {
		EntityManager em = PersistenceFactory.INSTANCE.getEntityManager();
		TypedQuery<RestaurantTable> query = em.createQuery("""
				select r from RestaurantTable r 
				left join fetch r.bookings 
				where r.name = :paramName """, RestaurantTable.class);
		query.setParameter("paramName", name);
		List<RestaurantTable> resultList = query.getResultList();
		em.close();
		return resultList;
	}

}
