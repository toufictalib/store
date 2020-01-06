package com.solutions.store.dao;

import java.util.List;

import com.solutions.store.model.Employee;


public interface EmployeeRepository {

	public Employee findById(Integer id);
	
	public List<Employee> findAll();
	
	
}