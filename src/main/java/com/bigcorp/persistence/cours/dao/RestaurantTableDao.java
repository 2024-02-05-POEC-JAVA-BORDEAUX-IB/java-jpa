package com.bigcorp.persistence.cours.dao;

import com.bigcorp.persistence.cours.model.RestaurantTable;
import com.bigcorp.persistence.cours.util.PersistenceFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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

}
