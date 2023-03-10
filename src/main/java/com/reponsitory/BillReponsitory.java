package com.reponsitory;

import java.util.Date;
import java.util.List;
import com.model.Bill;

public interface BillReponsitory {
	List<Bill> findAll();

	List<Bill> findAll(int position, int pageSize);

	List<Bill> findAll(int position, int pageSize, String name);

	List<Bill> findAll(Date start, Date end);

	Long countTotalRecords(String name);

	Bill getById(Integer Id);

	boolean add(Bill t);

	boolean edit(Bill t);

	public Boolean delete(Integer id);

}
