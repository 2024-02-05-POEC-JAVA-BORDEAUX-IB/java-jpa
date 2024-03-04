package com.bigcorp.persistence.cours;

import com.bigcorp.persistence.cours.model.Booking;

public class BookingDaoMain {

	public static void main(String[] args) {
		BookingDao bookingDao = new BookingDao();

		Booking b = bookingDao.findById(4l);

		if (b == null) {
			System.out.println("Pas de booking trouvé");
		} else {
			System.out.println("Pas de booking trouvé");
		}

	}

}
