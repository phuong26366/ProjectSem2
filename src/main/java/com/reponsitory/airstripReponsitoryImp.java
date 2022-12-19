package com.reponsitory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.DuongBay;
import com.model.MayBay;
@Repository
public class airstripReponsitoryImp implements DaoReponsitory<DuongBay, Integer>{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<DuongBay> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			List<DuongBay> list = session.createCriteria(DuongBay.class).list();
			session.getTransaction().commit();
			session.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return null;
	}

	@Override
	public List<DuongBay> findAll(int position, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DuongBay> findAll(int position, int pageSize, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countTotalRecords(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DuongBay getById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(DuongBay t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean edit(DuongBay t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
