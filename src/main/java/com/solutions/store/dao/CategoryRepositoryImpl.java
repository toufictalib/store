package com.solutions.store.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.solutions.store.bean.Provider;
import com.solutions.store.model.Category;
import com.solutions.store.model.CategoryWithoutDiscount;

@Repository
public class CategoryRepositoryImpl extends StoreRepositoryImpl<Category> implements CategoryRepository {

	public CategoryRepositoryImpl() {
		super();
	}

	@Override
	public List<CategoryWithoutDiscount> getCategoryWithoutDiscounts() {
		return Provider.listOfCategoryWithoutDiscount();
	}

}
