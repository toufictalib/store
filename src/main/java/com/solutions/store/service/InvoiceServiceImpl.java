package com.solutions.store.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutions.store.bean.Provider;
import com.solutions.store.dao.EmployeeRepository;
import com.solutions.store.dao.InvoiceRepository;
import com.solutions.store.dicount.Discount;
import com.solutions.store.model.CategoryWithoutDiscount;
import com.solutions.store.model.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public Optional<Invoice> getInvoice(int id) {
		Invoice invoice = invoiceRepository.findById(id);
		
		if(invoice==null) {
			return Optional.empty();
		}
		
		List<CategoryWithoutDiscount> categoryWithoutDiscounts = Provider.listOfCategoryWithoutDiscount();
		Set<Integer> categoriesWithoutDiscountIds = categoryWithoutDiscounts.stream().map(e->e.getCategory().getId()).collect(Collectors.toSet());
		
		List<Discount> discounts = Provider.discounts(invoice, categoriesWithoutDiscountIds);
		
		int discountAmount  = 0;
		for(Discount discount : discounts) {
			discountAmount = discount.getDiscountAmount();
			System.out.println("Discount Amount "+discountAmount);
			if(discount.getDiscountStatus()) {
				invoice.setDiscount(discountAmount);
				break;
			}
		}
		
		
		invoiceRepository.add(invoice);
		
		return Optional.of(invoice);
		
	}
	
	
	
}
