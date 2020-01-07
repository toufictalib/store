package com.solutions.store.dicount;

import com.solutions.store.model.Affiliate;
import com.solutions.store.model.Invoice;

public class AffiliateDiscount extends Discount {

	public AffiliateDiscount(Invoice discountInput) {
		super(discountInput);
	}

	@Override
	public int getDiscountAmount() {

		if (invoice.getUser() instanceof Affiliate) {
			hasDiscount = true;
			return invoice.getTotal() * 10 / 100;
		}
		return 0;

	}

}
