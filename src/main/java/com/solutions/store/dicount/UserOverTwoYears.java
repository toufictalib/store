package com.solutions.store.dicount;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;

import com.solutions.store.model.Invoice;

public class UserOverTwoYears extends Discount {

	public UserOverTwoYears(Invoice invoice, Set<Integer> categoryWithoutDiscounts) {
		super(invoice, categoryWithoutDiscounts);
	}

	@Override
	public int getDiscountAmount() {

		if (invoice.getUser().getCreationDate().until(LocalDate.now(), ChronoUnit.YEARS) > 2) {
			hasDiscount = true;
			return getAmountSupportDiscount() * 5 / 100;
		}
		return 0;
	}

}
