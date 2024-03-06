package com.bigcorp.persistence.cours.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class InvoiceId {

	private String year;

	private Integer uniqueNumber;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getUniqueNumber() {
		return uniqueNumber;
	}

	public void setUniqueNumber(Integer uniqueNumber) {
		this.uniqueNumber = uniqueNumber;
	}

}
