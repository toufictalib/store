package com.solutions.store.bean;

import java.util.Set;

import com.solutions.store.model.Invoice;

public class DiscountPerOneHundred extends Discount {

	public DiscountPerOneHundred(Invoice invoice, Set<Integer> categoryWithoutDiscounts) {
		super(invoice,categoryWithoutDiscounts);
	}

	@Override
	public int getDiscountAmount() {
		
		if(getAmountSupportDiscount()%100 > 0) {
			hasDiscount = true;
			return (getAmountSupportDiscount() % 100) * 5;
		}
		return 0;
	}

}
