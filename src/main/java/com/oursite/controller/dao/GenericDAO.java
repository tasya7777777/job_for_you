package main.java.com.oursite.controller.dao;

import java.util.List;

public interface GenericDAO<T> {

	public T get(int id);

	public List<T> getAll();

	public int insert(T object);

	public int update(T object);

	public int delete(int id);

}
