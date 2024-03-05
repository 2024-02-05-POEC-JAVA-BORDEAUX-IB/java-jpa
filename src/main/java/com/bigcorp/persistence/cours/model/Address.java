package com.bigcorp.persistence.cours.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

	private String postcode;
	private String city;

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
