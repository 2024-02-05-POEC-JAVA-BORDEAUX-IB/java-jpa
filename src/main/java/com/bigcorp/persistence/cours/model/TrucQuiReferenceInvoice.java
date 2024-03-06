package com.bigcorp.persistence.cours.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

/**
 * Exemple d'une clé composite en clé étrangère
 */
@Entity
public class TrucQuiReferenceInvoice {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@ManyToOne
	@JoinColumns({@JoinColumn(name="INVOICE_YEAR"),@JoinColumn(name="INVOICE_UNIQUE_NUMBER")})
	private Invoice invoice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	

}
