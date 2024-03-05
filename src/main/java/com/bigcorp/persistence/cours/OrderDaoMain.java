package com.bigcorp.persistence.cours;

import java.time.LocalDateTime;

import com.bigcorp.persistence.cours.dao.OrderDao;
import com.bigcorp.persistence.cours.model.OrderFormateur;
import com.bigcorp.persistence.cours.model.Status;

public class OrderDaoMain {

	public static void main(String[] args) {
		OrderDao orderDao = new OrderDao();
		
		OrderFormateur newOrder = new OrderFormateur();
		newOrder.setName("Nouvelle commande");
		newOrder.setStatus(Status.SOSO);
		newOrder.setOrderDate(LocalDateTime.now());
		
		orderDao.save(newOrder);
		

	}

}
