package com.bigcorp.persistence.cours;

import java.util.List;

import com.bigcorp.persistence.cours.dao.BookingDao;
import com.bigcorp.persistence.cours.dao.OrderDao;
import com.bigcorp.persistence.cours.dao.RestaurantTableDao;
import com.bigcorp.persistence.cours.model.Address;
import com.bigcorp.persistence.cours.model.Booking;
import com.bigcorp.persistence.cours.model.OrderFormateur;
import com.bigcorp.persistence.cours.model.RestaurantTable;

public class BookingDaoMain {

	public static void main(String[] args) {
		BookingDao bookingDao = new BookingDao();
		OrderDao orderDao = new OrderDao();
		RestaurantTableDao restaurantTableDao = new RestaurantTableDao();

		// Création d'un booking
		Booking newBooking = new Booking();
		newBooking.setName("Reservation du 30 février");

		// Création d'une adresse et rattachement à
		// newBooking
		Address addresse1 = new Address();
		newBooking.setAddress(addresse1);
		addresse1.setCity("Montpellier");
		addresse1.setPostcode("34000");

		// Création du orderFormateur
		OrderFormateur orderFormateur = new OrderFormateur();
		orderFormateur.setName("Commande Roger");
		OrderFormateur savedOrder = orderDao.save(orderFormateur);

		// Création du restaurant Table
		RestaurantTable rt = new RestaurantTable();
		rt.setName("Notre meilleure table !");
		RestaurantTable savedRestaurantTable = restaurantTableDao.save(rt);

		// Rattachement de savedOrder à newBooking
		newBooking.setOrderFormateur(savedOrder);
		savedOrder.getBookings().add(newBooking);

		// Rattachement de restaurantTable à newBooking
		newBooking.getRestaurantTables().add(savedRestaurantTable);

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

		// Affichage de tous les bookings de "Notre meilleure table"
		System.out.println("\n\n Affichage de tous les bookings liés à une table");
		List<RestaurantTable> bookingsDeLaMeilleureTable = restaurantTableDao
				.findByNameWithBookings("Notre meilleure table !");
		for (RestaurantTable restaurantTable : bookingsDeLaMeilleureTable) {
			for (Booking booking : restaurantTable.getBookings()) {
				System.out.println("La table : " + restaurantTable.getName() + " est liée à la réservation : "
						+ booking.getName());
			}
		}

		System.out.println("\n\n Affichage de toutes les tables liées à une commande");
		List<OrderFormateur> orders = orderDao.findByNameWithBookingsAndTables("Commande Roger");
		for (OrderFormateur order : orders) {
			for (Booking booking : order.getBookings()) {
				for (RestaurantTable restaurantTable : booking.getRestaurantTables()) {
					System.out.println("La table : "
							+ restaurantTable.getName()
							+ " est liée à la réservation : "
							+ booking.getName()
							+ " de la commande : "
							+ order.getName());
				}
			}
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
