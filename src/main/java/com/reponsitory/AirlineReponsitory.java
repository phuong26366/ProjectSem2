package com.reponsitory;

import java.util.List;

import com.model.MayBay;
public interface AirlineReponsitory {
	List<MayBay> findAll();
	List<MayBay> findAll(int position, int pageSize);
	List<MayBay> findAll(int position, int pageSize, String name);
	Long countTotalRecords(String name);
	MayBay getById(Integer Id);
	boolean add(MayBay t);
	boolean edit(MayBay t);
	public Boolean delete(Integer id);

}
