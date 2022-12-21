package com.reponsitory;

import java.util.List;

import com.model.MayBay;
import com.model.TicketDetail;
public interface TicketDetailReponsitory {
	List<TicketDetail> findAll();
	List<TicketDetail> findAll(int position, int pageSize);
	List<TicketDetail> findAll(int position, int pageSize, String name);
	Long countTotalRecords(String name);
	TicketDetail getById(Integer Id);
	boolean add(TicketDetail t);
	boolean edit(TicketDetail t);
	public Boolean delete(Integer id);

}
