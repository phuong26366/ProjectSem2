package com.reponsitory;

import java.util.List;

import com.model.DuongBay;
public interface AirstripReponsitory {
	List<DuongBay> findAll();
	List<DuongBay> findAll(int position, int pageSize);
	List<DuongBay> findAll(int position, int pageSize, String name);
	Long countTotalRecords(String name);
	DuongBay getById(Integer Id);
	boolean add(DuongBay t);
	boolean edit(DuongBay t);
	public Boolean delete(Integer id);

}
