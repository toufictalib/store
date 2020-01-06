package com.solutions.store.bean;

import com.solutions.store.model.Category;
import com.solutions.store.model.Product;

public class Item {

	private final Product product;
	private final int quantity;

	public Item(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getId() {
		return product.getId();
	}

	public String getName() {
		return product.getName();
	}

	public int getPrice() {
		return product.getPrice();
	}

	public Category getCategory() {
		return product.getCategory();
	}
	
	public int getTotal() {
		return quantity * getPrice();
	}
	
	

}
