package com.solutions.store.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.solutions.store.model.Affiliate;
import com.solutions.store.model.Category;
import com.solutions.store.model.Employee;
import com.solutions.store.model.Invoice;
import com.solutions.store.model.Product;
import com.solutions.store.model.User;

@Repository
public class InvoiceRepositoryImpl implements InvoiceRepository {

	private final Map<Integer, Invoice> map;

	public InvoiceRepositoryImpl() {
		super();
		this.map = new HashMap<>();

		// employee
		User employee = new Employee();
		Invoice invoice = new Invoice(1, employee);
		invoice.addItem(products().get(0), 2);
		invoice.addItem(products().get(1), 1);

		// affiliate
		User affiliate = new Affiliate();
		Invoice invoice2 = new Invoice(2, affiliate);
		invoice2.addItem(products().get(0), 3);
		invoice2.addItem(products().get(1), 1);
		invoice2.addItem(products().get(2), 2);

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

	public static List<Product> products() {
		List<Product> products = new ArrayList<>();

		Category groceryCategory = new Category(1, "Grocery");
		Category fashionCategory = new Category(2, "Fashion");
		Category electronicCategory = new Category(3, "Electronic");
		products.add(new Product(1, "Nescafe", 10, groceryCategory));
		products.add(new Product(2, "TV", 100, electronicCategory));
		products.add(new Product(3, "Sweater", 15, fashionCategory));

		return products;
	}
}
