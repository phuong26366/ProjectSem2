package com.reponsitory;

import java.util.List;

import com.model.MayBay;
import com.model.Staff;
public interface StaffReponsitory {
	List<Staff> findAll();
	List<Staff> findAll(int position, int pageSize);
	List<Staff> findAll(int position, int pageSize, String name);
	Long countTotalRecords(String name);
	Staff getById(Integer Id);
	boolean add(Staff t);
	boolean edit(Staff t);
	public Boolean delete(Integer id);

}
