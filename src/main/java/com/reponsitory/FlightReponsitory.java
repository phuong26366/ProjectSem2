package com.reponsitory;

import java.util.Date;
import java.util.List;

import com.model.Flight;
public interface FlightReponsitory {
	List<Flight> findAll();
	List<Flight> findAll(int position, int pageSize);
	List<Flight> findAll(int position, int pageSize, String name);
	List<Flight> findAll(int position, int pageSize, String diemDi , String diemDen , Date ngayBay , Boolean trangthai);
	Long countTotalRecords(String name);
	Flight getById(Integer Id);
	boolean add(Flight t);
	boolean edit(Flight t);
	public Boolean delete(Integer id);

}
