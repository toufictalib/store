package com.solutions.store.dicount;

public class AffiliateDiscount implements IDiscount {

	public AffiliateDiscount() {
		super();
	}

	@Override
	public int apply(int amount) {
		return amount * 10 / 100;
	}

}
