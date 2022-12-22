package com.reponsitory.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.Customer;
import com.reponsitory.AirlineReponsitory;
import com.reponsitory.CustomerReponsitory;


@Repository
public class CustomerReponsitoryImp implements CustomerReponsitory {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			List<Customer> list = session.createCriteria(Customer.class).list();
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
	public List<Customer> findAll(int position, int pageSize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Customer.class);
			criteria.setFirstResult(position);
			criteria.setMaxResults(pageSize);
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return null;
	}

	@Override
	public List<Customer> findAll(int position, int pageSize, String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Customer.class).add(Restrictions.like("tenKhachHang", "%" + name + "%"));
			criteria.setFirstResult(position);
			criteria.setMaxResults(pageSize);
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return null;
	}

	@Override
	public Long countTotalRecords(String name) {
		Session session = sessionFactory.openSession();
		Long count;
		if (name == null) {
			count = (Long) session.createCriteria(Customer.class).setProjection(Projections.rowCount()).uniqueResult();
		} else {
			count = (Long) session.createCriteria(Customer.class).setProjection(Projections.rowCount())
					.add(Restrictions.like("tenKhachHang", "%" + name + "%")).uniqueResult();
		}
		return count;
	}

	@Override
	public Customer getById(Integer Id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Customer c = (Customer) session.get(Customer.class, Id);
			session.getTransaction().commit();
			return c;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean add(Customer t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean edit(Customer t) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(t);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Customer p = session.load(Customer.class, id);
			session.remove(p);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

}
