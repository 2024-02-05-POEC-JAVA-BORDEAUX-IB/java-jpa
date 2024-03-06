package com.bigcorp.persistence.cours.dao;

import com.bigcorp.persistence.cours.model.Invoice;
import com.bigcorp.persistence.cours.model.TrucQuiReferenceInvoice;
import com.bigcorp.persistence.cours.util.PersistenceFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class InvoiceDao {

	public Invoice save(Invoice invoice) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Invoice savedInvoice = entityManager.merge(invoice);
		transaction.commit();
		entityManager.close();
		return savedInvoice;
	}
	
	public TrucQuiReferenceInvoice save(TrucQuiReferenceInvoice trucQuiReferenceInvoice) {
		EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		TrucQuiReferenceInvoice savedTrucQuiReferenceInvoice = entityManager.merge(trucQuiReferenceInvoice);
		transaction.commit();
		entityManager.close();
		return savedTrucQuiReferenceInvoice;
	}

	

}
