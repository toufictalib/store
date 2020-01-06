package com.solutions.store.bean;

import java.util.Set;

import com.solutions.store.model.Employee;
import com.solutions.store.model.Invoice;

public class EmployeeDiscount extends Discount {

	public EmployeeDiscount(Invoice invoice, Set<Integer> categoryWithoutDiscounts) {
		super(invoice, categoryWithoutDiscounts);
	}

	@Override
	public int getDiscountAmount() {

		if (invoice.getUser() instanceof Employee) {
			hasDiscount = true;
			return getAmountSupportDiscount() * 30 / 100;
		}
		return 0;

	}

}
