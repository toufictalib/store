package com.solutions.store.dicount;

import java.util.Set;

import com.solutions.store.model.Affiliate;
import com.solutions.store.model.Invoice;

public class AffiliateDiscount extends Discount {

	public AffiliateDiscount(Invoice invoice, Set<Integer> categoryWithoutDiscounts) {
		super(invoice, categoryWithoutDiscounts);
	}

	@Override
	public int getDiscountAmount() {

		if (invoice.getUser() instanceof Affiliate) {
			int amountSupportDiscount = getAmountSupportDiscount();
			hasDiscount = true;
			return amountSupportDiscount * 10 / 100;
		}
		return 0;

	}

}
