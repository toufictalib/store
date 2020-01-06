package com.solutions.store.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.solutions.store.model.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private final Map<Integer, Employee> map;
	
	
	public EmployeeRepositoryImpl() {
		super();
		this.map = new HashMap<>();
	}

	@Override
	public Employee findById(Integer id) {
		return map.get(id);
	}

	@Override
	public List<Employee> findAll() {
		return new ArrayList<>(map.values());
	}

}
