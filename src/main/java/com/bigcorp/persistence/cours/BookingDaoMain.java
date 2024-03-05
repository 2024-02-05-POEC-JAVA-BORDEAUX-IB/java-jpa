package com.bigcorp.persistence.cours;

import java.util.List;

import com.bigcorp.persistence.cours.dao.BookingDao;
import com.bigcorp.persistence.cours.model.Booking;

public class BookingDaoMain {

	public static void main(String[] args) {
		BookingDao bookingDao = new BookingDao();

		Booking newBooking = new Booking();
		newBooking.setName("Salut, j'ai été créé via le DAO !!");
		Booking savedBooking = bookingDao.save(newBooking);

		Booking b = bookingDao.findById(4l);

		if (b == null) {
			System.out.println("Pas de booking trouvé");
		} else {
			System.out.println("Pas de booking trouvé");
		}

		String bookingName = bookingDao.getNameWithNativeSQL(savedBooking.getId());
		System.out.println("Avec SELECT en vrai SQL , j'ai récupéré " + bookingName);

		List<Booking> bookingFromName = bookingDao.getBookingFromName("Salut, j'ai été créé via le DAO !!");
		for (Booking booking : bookingFromName) {
			System.out.println("J'ai trouvé le livre : " + booking.getName());
		}

	}

}
