package com.nonglam.authentication.service;

import java.util.List;

public interface IService<T> {
	List<T> findAll();
	T save(T t);
	T findOne(int id);
	T update(int id, T t);
}
