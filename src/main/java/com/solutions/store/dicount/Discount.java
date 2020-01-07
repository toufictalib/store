package com.solutions.store.dicount;

import java.util.Set;

import com.solutions.store.bean.Item;
import com.solutions.store.model.Invoice;

public abstract class Discount {

	protected final Invoice invoice;
	protected final Set<Integer> categoryWithoutDiscounts;
	
	protected boolean hasDiscount = false;

	public Discount(Invoice invoice, Set<Integer> categoryWithoutDiscounts) {
		super();
		this.invoice = invoice;
		this.categoryWithoutDiscounts  = categoryWithoutDiscounts;
	}

	protected final int getAmountSupportDiscount() {
		int sum = 0;
		for (Item item : invoice.getItems()) {
			if (!categoryWithoutDiscounts.contains(item.getCategory().getId())) {
				sum += item.getTotal();
			}
		}
		return sum;
	}

	public abstract int getDiscountAmount();

	public boolean getDiscountStatus() {
		return hasDiscount;
	}
}
