package com.swt1.prototype.models;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public interface DAO<T> {

	Optional<T> get(int id);

	List<T> getAll() throws InterruptedException, ExecutionException;

	boolean create(T t);

	void update(T t);

	boolean delete(T t);
}
