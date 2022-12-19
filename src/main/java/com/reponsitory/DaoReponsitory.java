package com.reponsitory;

import java.util.List;
public interface DaoReponsitory<T, Id> {
	List<T> findAll();
	List<T> findAll(int position, int pageSize);
	List<T> findAll(int position, int pageSize, String name);
	Long countTotalRecords(String name);
	T getById(Integer Id);
	boolean add(T t);
	boolean edit(T t);
	public Boolean delete(Integer id);

}
