package com.reponsitory;

import java.util.List;

import com.model.Airline;
public interface AirlineReponsitory {
	List<Airline> findAll();
	List<Airline> findAll(int position, int pageSize);
	List<Airline> findAll(int position, int pageSize, String name);
	Long countTotalRecords(String name);
	Airline getById(Integer Id);
	boolean add(Airline t);
	boolean edit(Airline t);
	public Boolean delete(Integer id);

}
