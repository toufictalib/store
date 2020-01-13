package com.solutions.store.bean;

import java.util.ArrayList;
import java.util.List;

import com.solutions.store.dicount.AffiliateDiscount;
import com.solutions.store.dicount.DiscountPerOneHundred;
import com.solutions.store.dicount.EmployeeDiscount;
import com.solutions.store.dicount.IDiscount;
import com.solutions.store.dicount.UserOverTwoYears;
import com.solutions.store.model.Category;
import com.solutions.store.model.CategoryWithoutDiscount;
import com.solutions.store.model.Product;

public class Provider {

	private Provider() {

	}

	public static List<CategoryWithoutDiscount> listOfCategoryWithoutDiscount() {
		List<CategoryWithoutDiscount> list = new ArrayList<>();
		list.add(new CategoryWithoutDiscount(new Category(1, "Grocery")));

		return list;
	}

	public static List<IDiscount> discounts() {
		List<IDiscount> discounts = new ArrayList<>();

		// discounts
		discounts.add(new EmployeeDiscount());
		discounts.add(new AffiliateDiscount());
		discounts.add(new DiscountPerOneHundred());
		discounts.add(new UserOverTwoYears());
		return discounts;
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
