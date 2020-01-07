package com.solutions.store.bean;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NotSupportedDiscountFilter {

	public List<Item> filter(List<Item> items, Set<Integer> categoryWithoutDiscounts) {
		return items.stream().filter(e -> !categoryWithoutDiscounts.contains(e.getCategory().getId()))
				.collect(Collectors.toList());
	}


}
