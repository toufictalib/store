package com.solutions.store.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.solutions.store.dicount.AffiliateDiscount;
import com.solutions.store.dicount.Discount;
import com.solutions.store.dicount.DiscountPerOneHundred;
import com.solutions.store.dicount.EmployeeDiscount;
import com.solutions.store.dicount.UserOverTwoYears;
import com.solutions.store.model.Affiliate;
import com.solutions.store.model.Category;
import com.solutions.store.model.CategoryWithoutDiscount;
import com.solutions.store.model.Employee;
import com.solutions.store.model.Invoice;
import com.solutions.store.model.Product;
import com.solutions.store.model.User;

public class Provider {

	private Provider() {

	}

	public static List<CategoryWithoutDiscount> listOfCategoryWithoutDiscount() {
		List<CategoryWithoutDiscount> list = new ArrayList<>();
		list.add(new CategoryWithoutDiscount(new Category(1, "Grocery")));

		return list;
	}
	
	public static List<Discount> discounts(Invoice invoice, Set<Integer> categoriesWithoutDiscountIds){
		List<Discount> discounts = new ArrayList<>();
		discounts.add(new EmployeeDiscount(invoice, categoriesWithoutDiscountIds));
		discounts.add(new AffiliateDiscount(invoice, categoriesWithoutDiscountIds));
		discounts.add(new DiscountPerOneHundred(invoice, categoriesWithoutDiscountIds));
		discounts.add(new UserOverTwoYears(invoice, categoriesWithoutDiscountIds));
		return discounts;
	}
	
	public static Invoice createAffiliateInvoice(Product ...  products) {
		// affiliate
		User affiliate = new Affiliate();
		Invoice invoice2 = new Invoice(2, affiliate);
		invoice2.addItem(products[0], 3);
		invoice2.addItem(products[1], 1);
		invoice2.addItem(products[2], 2);
		return invoice2;
	}

	public static Invoice createEmployeeInvoice(Product ...  products) {
		// employee
		User employee = new Employee();
		Invoice invoice = new Invoice(1, employee);
		invoice.addItem(products[0], 2);
		invoice.addItem(products[1], 1);
		return invoice;
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
