package com.bigcorp.persistence.cours.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private String name;

	private Integer note;

	@Embedded
	private Address address;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ORDER_FORMATEUR_ID")
	private OrderFormateur orderFormateur;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public OrderFormateur getOrderFormateur() {
		return orderFormateur;
	}

	public void setOrderFormateur(OrderFormateur orderFormateur) {
		this.orderFormateur = orderFormateur;
	}

}
