package com.solutions.store.dicount;

public class EmployeeDiscount implements IDiscount {

	public EmployeeDiscount() {
		super();
	}

	@Override
	public int apply(int amount) {
		return amount * 30 / 100;
	}

}
