package com.solutions.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.solutions.store.bean.Item;
import com.solutions.store.bean.Provider;
import com.solutions.store.model.Affiliate;
import com.solutions.store.model.Employee;
import com.solutions.store.model.Invoice;
import com.solutions.store.model.NormalUser;
import com.solutions.store.model.Product;
import com.solutions.store.model.User;
import com.solutions.store.service.InvoiceService;

@SpringBootApplication
public class StoreApplication implements CommandLineRunner {

	@Autowired
	InvoiceService invoiceService;

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		User affiliate = new Affiliate(2, "Affiliate");
		User employee = new Employee(1, "Toufic");
		User normal = new NormalUser(3, "Normal User");

		List<Item> items = new ArrayList<>();

		List<Product> products = Provider.products();

		items.add(new Item(products.get(0), 2));
		items.add(new Item(products.get(1), 1));

		Invoice invoice = invoiceService.createInvoice(employee, items);

		Optional<Invoice> invoice2 = invoiceService.getInvoice(invoice.getId());

		if (invoice2.isPresent()) {
			System.out.println(invoice2.get());
		}

		System.out.println("----------Affiliate--------");
		Invoice invoice3 = invoiceService.createInvoice(affiliate, items);

		Optional<Invoice> invoice3Op = invoiceService.getInvoice(invoice3.getId());

		if (invoice3Op.isPresent()) {
			System.out.println(invoice3Op.get());
		}

		System.out.println("----------Normal But the invoice is over 100--------");
		Invoice invoice4 = invoiceService.createInvoice(normal, items);

		Optional<Invoice> invoice4Op = invoiceService.getInvoice(invoice4.getId());

		if (invoice4Op.isPresent()) {
			System.out.println(invoice4Op.get());
		}

	}

}
