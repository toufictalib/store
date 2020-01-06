package com.solutions.store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutions.store.bean.AffiliateDiscount;
import com.solutions.store.bean.Discount;
import com.solutions.store.bean.DiscountPerOneHundred;
import com.solutions.store.bean.EmployeeDiscount;
import com.solutions.store.bean.UserOverTwoYears;
import com.solutions.store.dao.EmployeeRepository;
import com.solutions.store.dao.InvoiceRepository;
import com.solutions.store.model.CategoryWithoutDiscount;
import com.solutions.store.model.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public Invoice getInvoice(int id) {
		Invoice invoice = invoiceRepository.findById(2);
		
		List<CategoryWithoutDiscount> categoryWithoutDiscounts = CategoryWithoutDiscount.list();
		Set<Integer> categoriesWithoutDiscountIds = categoryWithoutDiscounts.stream().map(e->e.getCategory().getId()).collect(Collectors.toSet());
		List<Discount> discounts = new ArrayList<>();
		discounts.add(new EmployeeDiscount(invoice, categoriesWithoutDiscountIds));
		discounts.add(new AffiliateDiscount(invoice, categoriesWithoutDiscountIds));
		discounts.add(new DiscountPerOneHundred(invoice, categoriesWithoutDiscountIds));
		discounts.add(new UserOverTwoYears(invoice, categoriesWithoutDiscountIds));
		
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
		
		return invoice;
		
	}
	
	
	
}
