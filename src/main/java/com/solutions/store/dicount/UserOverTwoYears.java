package com.solutions.store.dicount;

public class UserOverTwoYears implements IDiscount {

	public UserOverTwoYears() {
		super();
	}


	@Override
	public int apply(int amount) {
		return amount * 5 / 100;
	}

}
