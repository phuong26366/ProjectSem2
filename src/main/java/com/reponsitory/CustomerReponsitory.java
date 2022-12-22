package com.reponsitory;

import java.util.List;
import com.model.Customer;
public interface CustomerReponsitory {
	List<Customer> findAll();
	List<Customer> findAll(int position, int pageSize);
	List<Customer> findAll(int position, int pageSize, String name);
	Long countTotalRecords(String name);
	Customer getById(Integer Id);
	boolean add(Customer t);
	boolean edit(Customer t);
	public Boolean delete(Integer id);

}
