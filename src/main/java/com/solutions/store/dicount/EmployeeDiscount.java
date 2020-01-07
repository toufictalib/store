package com.solutions.store.dicount;

import com.solutions.store.model.Employee;
import com.solutions.store.model.Invoice;

public class EmployeeDiscount extends Discount {

	public EmployeeDiscount(Invoice discountInput) {
		super(discountInput);
	}

	@Override
	public int getDiscountAmount() {

		if (invoice.getUser() instanceof Employee) {
			hasDiscount = true;
			return invoice.getTotal() * 30 / 100;
		}
		return 0;

	}

}
