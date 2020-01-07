package com.solutions.store.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.solutions.store.bean.Item;

public class Invoice {

	private int id;
	private final User user;
	private final List<Item> items;
	private int discount;
	private LocalDateTime creationDate;

	private static int CTR = 1;

	public Invoice(User user) {
		super();
		this.id = CTR++;
		this.user = user;
		this.items = new ArrayList<>();
		this.creationDate = LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public List<Item> getItems() {
		return items;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	
	public void removeItems() {
		items.clear();
	}

	public void addItem(Product product, int quantity) {
		items.add(new Item(product, quantity));
	}

	public void addItems(List<Item> items) {
		this.items.addAll(items);
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public int getTotal() {
		return 0;
	}
	public int getNetPayableAmount() {
		return getTotal() - discount;
	}
	
	public Invoice clone() {
		Invoice invoice = new Invoice(this.user);
		invoice.id = this.id;
		invoice.addItems(this.items);
		invoice.discount = this.discount;
		invoice.creationDate = creationDate;

		return invoice;
	}

}
