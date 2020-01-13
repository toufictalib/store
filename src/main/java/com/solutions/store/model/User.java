package com.solutions.store.model;

import java.time.LocalDate;

public class User extends BaseEntity {

	private String name;
	private LocalDate creationDate;
	
	public User() {
		this.creationDate = LocalDate.now();
	}

	public User(int id, String name) {
		super(id);
		this.creationDate = LocalDate.now();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	

}
