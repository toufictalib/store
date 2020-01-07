package com.solutions.store.service;

import java.util.Optional;

import com.solutions.store.model.Invoice;

public interface InvoiceService {

	Optional<Invoice> getInvoice(int id);

	
}
