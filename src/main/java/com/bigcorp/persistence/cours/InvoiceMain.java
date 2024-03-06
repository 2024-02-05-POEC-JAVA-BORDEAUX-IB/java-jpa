package com.bigcorp.persistence.cours;

import com.bigcorp.persistence.cours.dao.InvoiceDao;
import com.bigcorp.persistence.cours.model.Invoice;
import com.bigcorp.persistence.cours.model.InvoiceId;
import com.bigcorp.persistence.cours.model.TrucQuiReferenceInvoice;

public class InvoiceMain {

	public static void main(String[] args) {
		InvoiceDao invoiceDao = new InvoiceDao();

		Invoice invoice = new Invoice();
		invoice.setName("Facture importante");
		InvoiceId invoiceId = new InvoiceId();
		invoiceId.setUniqueNumber(1);
		invoiceId.setYear("2004");
		invoice.setId(invoiceId);

		Invoice savedInvoice = invoiceDao.save(invoice);

		TrucQuiReferenceInvoice quiReferenceInvoice = new TrucQuiReferenceInvoice();
		quiReferenceInvoice.setInvoice(savedInvoice);

		invoiceDao.save(quiReferenceInvoice);

	}

}
