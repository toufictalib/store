package com.solutions.store.dao;

import java.util.List;

import com.solutions.store.model.BaseEntity;

public interface StoreRepository<T extends BaseEntity> {

	public T findById(Integer id);

	public List<T> findAll();

	public void add(T t);

	public void delete(Integer id);
}
