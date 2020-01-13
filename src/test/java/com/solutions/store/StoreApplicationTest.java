package com.solutions.store;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.solutions.store.bean.Item;
import com.solutions.store.bean.Provider;
import com.solutions.store.model.Affiliate;
import com.solutions.store.model.Employee;
import com.solutions.store.model.Invoice;
import com.solutions.store.model.Product;
import com.solutions.store.model.User;
import com.solutions.store.service.InvoiceService;

@SpringBootTest
class StoreApplicationTest {

	@Autowired
	InvoiceService invoiceService;


	@Test
	void createEmployeeInvoice() {
		User employee = new Employee(1, "Toufic");

		List<Product> products = Provider.products();
		List<Item> items = new ArrayList<>();
		items.add(new Item(products.get(0), 2));
		items.add(new Item(products.get(1), 1));

		Invoice invoice = invoiceService.createInvoice(employee, items);

		Optional<Invoice> invoice2 = invoiceService.getInvoice(invoice.getId());

		if (invoice2.isPresent()) {
			System.out.println(invoice2.get());
		}
		assertTrue(invoice.getDiscount() == 30);
	}

	public static Invoice createAffiliateInvoice(Product... products) {
		// affiliate
		User affiliate = new Affiliate();
		Invoice invoice2 = new Invoice(affiliate);
		invoice2.addItem(products[0], 3);
		invoice2.addItem(products[1], 1);
		invoice2.addItem(products[2], 2);
		return invoice2;
	}

	public static Invoice createEmployeeInvoice(Product... products) {
		// employee
		User employee = new Employee();
		Invoice invoice = new Invoice(employee);
		invoice.addItem(products[0], 2);
		invoice.addItem(products[1], 1);
		return invoice;
	}

}
