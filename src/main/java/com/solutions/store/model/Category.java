package com.solutions.store.model;

public class Category extends BaseEntity {

	private String name;

	public Category() {
		super();
	}

	public Category(int id, String name) {
		super(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
