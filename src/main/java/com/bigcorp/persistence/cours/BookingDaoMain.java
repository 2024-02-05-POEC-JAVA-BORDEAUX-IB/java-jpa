package com.bigcorp.persistence.cours;

import com.bigcorp.persistence.cours.dao.BookingDao;
import com.bigcorp.persistence.cours.dao.OrderDao;
import com.bigcorp.persistence.cours.model.Address;
import com.bigcorp.persistence.cours.model.Booking;
import com.bigcorp.persistence.cours.model.OrderFormateur;

public class BookingDaoMain {

	public static void main(String[] args) {
		BookingDao bookingDao = new BookingDao();
		OrderDao orderDao = new OrderDao();

		// Création d'un booking
		Booking newBooking = new Booking();
		newBooking.setName("Salut, j'ai été créé via le DAO !!");

		// Création d'une adresse et rattachement à
		// newBooking
		Address addresse1 = new Address();
		newBooking.setAddress(addresse1);
		addresse1.setCity("Montpellier");
		addresse1.setPostcode("34000");

		// Création du orderFormateur
		OrderFormateur orderFormateur = new OrderFormateur();
		orderFormateur.setName("Super commande");
		OrderFormateur savedOrder = orderDao.save(orderFormateur);

		// Rattachement de savedOrder à newBooking
		newBooking.setOrderFormateur(savedOrder);

		// Sauvegarde
		Booking savedBooking = bookingDao.save(newBooking);
		
		Booking booking2 = new Booking();
		booking2.setOrderFormateur(savedOrder);
		bookingDao.save(booking2);
		
		Booking booking3 = new Booking();
		booking3.setOrderFormateur(savedOrder);
		bookingDao.save(booking3);
		
		Booking booking4 = new Booking();
		booking4.setOrderFormateur(savedOrder);
		bookingDao.save(booking4);
		

		// Récupération du booking et du ORderFormateur associé
		Booking bookingFromDatabase = bookingDao.findByIdWithOrderFormateur(savedBooking.getId());
		System.out.println("Le nom de l'orderFormateur rattaché à booking vaut : "
				+ bookingFromDatabase.getOrderFormateur().getName());

		OrderFormateur orderQuiVientDeLaBase = orderDao.findByIdWithBookings(savedOrder.getId());
		for (Booking booking : orderQuiVientDeLaBase.getBookings()) {
			System.out.println("Le booking avec le nom " + booking.getName() + " est lié à order "
					+ orderQuiVientDeLaBase.getName());
		}

//		
//		
//		
//		
//		
//		if (b == null) {
//			System.out.println("Pas de booking trouvé");
//		} else {
//			System.out.println("Pas de booking trouvé");
//		}
//
//		String bookingName = bookingDao.getNameWithNativeSQL(savedBooking.getId());
//		System.out.println("\n\nAvec SELECT en vrai SQL , j'ai récupéré " + bookingName);
//
//		System.out.println("\n\nRecherche classique");
//		List<Booking> bookingFromName = bookingDao.getBookingFromName("Salut, j'ai été créé via le DAO !!");
//		for (Booking booking : bookingFromName) {
//			System.out.println("J'ai trouvé le livre : " + booking.getName());
//		}
//
//		System.out.println("\n\nRecherche avec like");
//		List<Booking> bookingFromNameLike = bookingDao.getBookingFromNameLike("a");
//		for (Booking booking : bookingFromNameLike) {
//			System.out.println("J'ai trouvé le livre : " + booking.getName());
//		}
	}

}
