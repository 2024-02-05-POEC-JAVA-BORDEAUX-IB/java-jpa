package com.bigcorp.persistence.cours.dao;

import com.bigcorp.persistence.cours.model.OrderFormateur;
import com.bigcorp.persistence.cours.util.PersistenceFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OrderDao {

	public OrderFormateur save(OrderFormateur order) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		OrderFormateur savedOrder = entityManager.merge(order);
		transaction.commit();
		entityManager.close();
		return savedOrder;
	}

	public OrderFormateur find(Long id) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		OrderFormateur order = entityManager.find(OrderFormateur.class, id);
		entityManager.close();
		return order;
	}

	public void delete(Long id) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		OrderFormateur savedOrder = entityManager.find(OrderFormateur.class, id);
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
