package com.solutions.store.dicount;

import com.solutions.store.model.Invoice;

public abstract class Discount {

	protected final Invoice invoice;
	
	protected boolean hasDiscount = false;

	public Discount(Invoice invoice) {
		super();
		this.invoice = invoice;
	}


	public abstract int getDiscountAmount();

	public boolean getDiscountStatus() {
		return hasDiscount;
	}
}
