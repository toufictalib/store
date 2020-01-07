package com.solutions.store.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.solutions.store.bean.Provider;
import com.solutions.store.model.Invoice;
import com.solutions.store.model.Product;

@Repository
public class InvoiceRepositoryImpl implements InvoiceRepository {

	private final Map<Integer, Invoice> map;

	public InvoiceRepositoryImpl() {
		super();
		this.map = new HashMap<>();

		List<Product> products = Provider.products();
		
		Invoice invoice = Provider.createEmployeeInvoice(products.get(0), products.get(1));

		Invoice invoice2 = Provider.createAffiliateInvoice(products.get(0), products.get(1), products.get(2));

		map.put(invoice.getId(), invoice);
		map.put(invoice2.getId(), invoice2);
	}

	

	@Override
	public Invoice findById(Integer id) {
		return map.get(id);
	}

	@Override
	public List<Invoice> findAll() {
		return new ArrayList<>(map.values());
	}

	@Override
	public void add(Invoice invoice) {
		map.put(invoice.getId(), invoice);

	}

	
}
