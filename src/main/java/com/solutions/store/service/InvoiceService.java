package com.solutions.store.service;

import java.util.List;
import java.util.Optional;

import com.solutions.store.bean.Item;
import com.solutions.store.model.Invoice;
import com.solutions.store.model.User;

public interface InvoiceService {

	Optional<Invoice> getInvoice(int id);

	Optional<Invoice> addInvoice(User user, List<Item> items);
	
}
