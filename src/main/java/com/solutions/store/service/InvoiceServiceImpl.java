package com.solutions.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutions.store.bean.Item;
import com.solutions.store.bean.Provider;
import com.solutions.store.dao.EmployeeRepository;
import com.solutions.store.dao.InvoiceRepository;
import com.solutions.store.dicount.Discount;
import com.solutions.store.model.Invoice;
import com.solutions.store.model.User;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	InvoiceRepository invoiceRepository;

	@Override
	public Optional<Invoice> getInvoice(int id) {
		Invoice invoice = invoiceRepository.findById(id);

		return invoice == null ? Optional.empty() : Optional.of(invoice);

	}

	@Override
	public Optional<Invoice> addInvoice(User user, List<Item> items) {

		// create invoice
		Invoice invoice = new Invoice(user);
		invoice.addItems(items);


		// List of discounts supported by store
		List<Discount> discounts = Provider.discounts(invoice);

		int discountAmount = 0;
		for (Discount discount : discounts) {
			discountAmount = discount.getDiscountAmount();
			if (discount.getDiscountStatus()) {
				invoice.setDiscount(discountAmount);
				break;
			}
		}

		invoiceRepository.add(invoice);

		return Optional.of(invoice);

	}

}
