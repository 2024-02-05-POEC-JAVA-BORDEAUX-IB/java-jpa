package com.bigcorp.persistence.cours.dao;

import com.bigcorp.persistence.cours.model.Order;
import com.bigcorp.persistence.cours.util.PersistenceFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OrderDao {

	public Order save(Order order) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Order savedOrder = entityManager.merge(order);
		transaction.commit();
		entityManager.close();
		return savedOrder;
	}

	public Order find(Long id) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		Order order = entityManager.find(Order.class, id);
		entityManager.close();
		return order;
	}

	public void delete(Long id) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		Order savedOrder = entityManager.find(Order.class, id);
		if (savedOrder == null) {
			return;
		}
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(savedOrder);
		transaction.commit();
		entityManager.close();
	}

}
