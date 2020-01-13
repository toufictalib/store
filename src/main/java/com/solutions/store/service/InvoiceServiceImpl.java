package com.solutions.store.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutions.store.bean.Item;
import com.solutions.store.dao.CategoryRepository;
import com.solutions.store.dao.InvoiceRepository;
import com.solutions.store.dicount.AffiliateDiscount;
import com.solutions.store.dicount.DiscountPerOneHundred;
import com.solutions.store.dicount.EmployeeDiscount;
import com.solutions.store.dicount.IDiscount;
import com.solutions.store.dicount.UserOverTwoYears;
import com.solutions.store.model.Affiliate;
import com.solutions.store.model.CategoryWithoutDiscount;
import com.solutions.store.model.Employee;
import com.solutions.store.model.Invoice;
import com.solutions.store.model.User;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceRepository invoiceRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Optional<Invoice> getInvoice(int id) {
		Invoice invoice = invoiceRepository.findById(id);

		return invoice == null ? Optional.empty() : Optional.of(invoice);

	}


	@Override
	public Invoice createInvoice(User user, List<Item> items) {

		// create invoice
		Invoice invoice = new Invoice(user);
		invoice.addItems(items);

		List<Item> onlySupportDiscountITems = filter(invoice.getItems());
		
		IDiscount discount = getDiscount(invoice);
		System.out.println(discount.getClass().getSimpleName());
		invoice.setDiscount(discount.apply(
				onlySupportDiscountITems.stream().map(e -> e.getPrice() * e.getQuantity()).reduce(0, Integer::sum)));

		invoiceRepository.add(invoice);

		return invoice;

	}


	private List<Item> filter(List<Item> items) {
		// list of categories that not support discount
		List<CategoryWithoutDiscount> categoryWithoutDiscounts = categoryRepository.getCategoryWithoutDiscounts();
		// convert category to Set because Set of id complexity is one(High
		// performance)
		Set<Integer> categoriesWithoutDiscountIds = categoryWithoutDiscounts.stream().map(e -> e.getCategory().getId())
				.collect(Collectors.toSet());

		return items.stream().filter(e -> !categoriesWithoutDiscountIds.contains(e.getCategory().getId()))
				.collect(Collectors.toList());
	}

	private IDiscount getDiscount(Invoice invoice) {
		User user = invoice.getUser();
		if (user instanceof Employee) {
			return new EmployeeDiscount();
		} else if (user instanceof Affiliate) {
			return new AffiliateDiscount();
		} else if (user.getCreationDate().until(LocalDate.now(), ChronoUnit.YEARS) > 2) {
			return new UserOverTwoYears();
		}
		return new DiscountPerOneHundred();

	}

}
