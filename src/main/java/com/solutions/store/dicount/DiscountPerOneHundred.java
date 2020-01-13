package com.solutions.store.dicount;

public class DiscountPerOneHundred implements IDiscount {

	public DiscountPerOneHundred() {
		super();
	}

	@Override
	public int apply(int amount) {
		return amount % 100 * 5;
	}

}
