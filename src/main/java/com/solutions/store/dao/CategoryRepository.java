package com.solutions.store.dao;

import java.util.List;

import com.solutions.store.model.Category;
import com.solutions.store.model.CategoryWithoutDiscount;

public interface CategoryRepository extends StoreRepository<Category> {

	public List<CategoryWithoutDiscount> getCategoryWithoutDiscounts();
	
	
}