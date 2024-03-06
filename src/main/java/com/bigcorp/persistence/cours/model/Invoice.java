package com.bigcorp.persistence.cours.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

/**
 * Exemple d'une clé primaire en clé composite
 */
@Entity
public class Invoice {

	@EmbeddedId
	private InvoiceId id;

	private String name;

	public InvoiceId getId() {
		return id;
	}

	public void setId(InvoiceId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
