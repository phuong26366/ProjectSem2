package com.reponsitory;

import java.util.List;

import com.model.ChuyenBay;
public interface FlightReponsitory {
	List<ChuyenBay> findAll();
	List<ChuyenBay> findAll(int position, int pageSize);
	List<ChuyenBay> findAll(int position, int pageSize, String name);
	Long countTotalRecords(String name);
	ChuyenBay getById(Integer Id);
	boolean add(ChuyenBay t);
	boolean edit(ChuyenBay t);
	public Boolean delete(Integer id);

}
