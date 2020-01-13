package com.solutions.store.model;

public class BaseEntity {

	protected Integer id;

	public BaseEntity() {
		super();
	}

	public BaseEntity(Integer id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
