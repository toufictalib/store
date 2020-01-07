package com.solutions.store.dicount;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.solutions.store.model.Invoice;

public class UserOverTwoYears extends Discount {

	public UserOverTwoYears(Invoice invoice) {
		super(invoice);
	}

	@Override
	public int getDiscountAmount() {

		if (invoice.getUser().getCreationDate().until(LocalDate.now(), ChronoUnit.YEARS) > 2) {
			hasDiscount = true;
			return invoice.getTotal() * 5 / 100;
		}
		return 0;
	}

}
