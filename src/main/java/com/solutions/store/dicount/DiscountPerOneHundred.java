package com.solutions.store.dicount;

import com.solutions.store.model.Invoice;

public class DiscountPerOneHundred extends Discount {

	public DiscountPerOneHundred(Invoice discountInput) {
		super(discountInput);
	}

	@Override
	public int getDiscountAmount() {
		
		int total = invoice.getTotal();
		if (total % 100 > 0) {
			hasDiscount = true;
			return (total % 100) * 5;
		}
		return 0;
	}

}
