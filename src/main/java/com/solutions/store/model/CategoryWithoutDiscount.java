package com.solutions.store.model;

import java.util.ArrayList;
import java.util.List;

public class CategoryWithoutDiscount {

	private final Category category;

	public CategoryWithoutDiscount(Category category) {
		super();
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}
	
	public static List<CategoryWithoutDiscount> list(){
		List<CategoryWithoutDiscount> list = new ArrayList<>();
		list.add(new CategoryWithoutDiscount( new Category(1, "Grocery")));
		
		return list;
	}

}
