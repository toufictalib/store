package com.solutions.store.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.solutions.store.bean.Item;

public class Invoice extends BaseEntity {

	private final User user;
	private final List<Item> items;
	private int discount;
	private LocalDateTime creationDate;

	private static int CTR = 1;

	public Invoice(User user) {
		super(CTR++);
		this.user = user;
		this.items = new ArrayList<>();
		this.creationDate = LocalDateTime.now();
	}

	public List<Item> getItems() {
		return items;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
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
		return getItems().stream().map(e -> e.getPrice() * e.getQuantity()).reduce(0, Integer::sum);
	}
	public int getNetPayableAmount() {
		return getTotal() - discount;
	}
	
	public User getUser() {
		return user;
	}

	public Invoice clone() {
		Invoice invoice = new Invoice(this.user);
		invoice.id = this.id;
		invoice.addItems(this.items);
		invoice.discount = this.discount;
		invoice.creationDate = creationDate;

		return invoice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Invoice # " + id + "\n");
		builder.append("Mr. " + user.getName() + "\n");
		builder.append("-----------------\n");
		builder.append("Desc\tQty\tPrice\tSubtotal\n");
		builder.append("-----------------\n");
		for (Item item : items) {
			builder.append(item.getName() + "\t" + item.getQuantity() + "\t" + item.getPrice() + "\t"
					+ item.getQuantity() * item.getPrice() + "\n");
		}

		builder.append("-----------------\n");
		builder.append("Total\t\t\t\t" + getTotal() + "\n");
		builder.append("Discount\t\t\t" + getDiscount() + "\n");
		builder.append("Net to pay \t\t\t" + getNetPayableAmount() + "\n");
		return builder.toString();
	}

}
