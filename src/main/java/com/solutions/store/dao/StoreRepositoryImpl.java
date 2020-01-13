package com.solutions.store.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.solutions.store.model.BaseEntity;

public class StoreRepositoryImpl<T extends BaseEntity> implements StoreRepository<T> {

	private Map<Integer, T> map = new HashMap<>();

	@Override
	public T findById(Integer id) {
		return map.get(id);
	}

	@Override
	public List<T> findAll() {
		return new ArrayList<>(map.values());
	}

	@Override
	public void add(T t) {
		map.put(t.getId(), t);
		
	}

	@Override
	public void delete(Integer id) {
		map.remove(id);

	}

}
