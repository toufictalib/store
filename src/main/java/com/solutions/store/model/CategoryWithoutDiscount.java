package com.solutions.store.model;

public class CategoryWithoutDiscount extends BaseEntity {

	private final Category category;

	public CategoryWithoutDiscount(Category category) {
		super();
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}
	

}
