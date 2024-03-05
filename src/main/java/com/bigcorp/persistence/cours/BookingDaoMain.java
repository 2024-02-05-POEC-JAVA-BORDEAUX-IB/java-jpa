package com.bigcorp.persistence.cours;

import java.util.List;

import com.bigcorp.persistence.cours.dao.BookingDao;
import com.bigcorp.persistence.cours.dao.OrderDao;
import com.bigcorp.persistence.cours.model.Address;
import com.bigcorp.persistence.cours.model.Booking;
import com.bigcorp.persistence.cours.model.OrderFormateur;

public class BookingDaoMain {

	public static void main(String[] args) {
		BookingDao bookingDao = new BookingDao();
		OrderDao orderDao = new OrderDao();

		Booking newBooking = new Booking();
		newBooking.setName("Salut, j'ai été créé via le DAO !!");

		Address addresse1 = new Address();
		newBooking.setAddress(addresse1);
		addresse1.setCity("Montpellier");
		addresse1.setPostcode("34000");
		
		OrderFormateur orderFormateur = new OrderFormateur();
		orderFormateur.setName("Super commande");
		OrderFormateur savedOrder = orderDao.save(orderFormateur);
		
		newBooking.setOrderFormateur(savedOrder);
		Booking savedBooking = bookingDao.save(newBooking);

		Booking newBooking2 = new Booking();
		newBooking.setName("Réservation de bAse");
		bookingDao.save(newBooking2);

		Booking b = bookingDao.findById(savedBooking.getId());
		b.getOrderFormateur().getName();
		System.out.println(b.getName());

		
		
		
		
		
		
		
		
		
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
