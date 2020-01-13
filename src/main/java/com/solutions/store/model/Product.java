package com.solutions.store.model;

public class Product extends BaseEntity {

	private String name;
	private int price;
	private Category category;

	public Product() {
		super();
	}

	public Product(int id, String name, int price, Category category) {
		super(id);
		this.name = name;
		this.price = price;
		this.category = category;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
