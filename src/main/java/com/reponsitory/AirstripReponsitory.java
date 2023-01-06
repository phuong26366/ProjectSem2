package com.reponsitory;

import java.util.List;

import com.model.Airstrip;
public interface AirstripReponsitory {
	List<Airstrip> findAll();
	List<Airstrip> findAll(int position, int pageSize);
	List<Airstrip> findAll(int position, int pageSize, String name);
	Long countTotalRecords(String name);
	Airstrip getById(Integer Id);
	boolean add(Airstrip t);
	boolean edit(Airstrip t);
	public Boolean delete(Integer id);

}
