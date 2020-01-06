package com.solutions.store.dao;

import java.util.List;

import com.solutions.store.model.Invoice;


public interface InvoiceRepository {

	public Invoice findById(Integer id);
	
	public List<Invoice> findAll();
	
	public void add(Invoice invoice);
	
}