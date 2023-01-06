package com.reponsitory.imp;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.Bill;
import com.reponsitory.BillReponsitory;

@Repository
public class BillReponsitoryImp implements BillReponsitory {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Bill> findAll() {
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			List<Bill> list = session.createCriteria(Bill.class).list();
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
	public List<Bill> findAll(int position, int pageSize) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Bill.class);
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
	public List<Bill> findAll(int position, int pageSize, String name) {
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Bill.class).add(Restrictions.like("diemDen", "%" + name + "%"));
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
			count = (Long) session.createCriteria(Bill.class).setProjection(Projections.rowCount()).uniqueResult();
		} else {
			count = (Long) session.createCriteria(Bill.class).setProjection(Projections.rowCount())
					.add(Restrictions.like("diemDen", "%" + name + "%")).uniqueResult();
		}
		return count;
	}

	@Override
	public Bill getById(Integer Id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Bill c = (Bill) session.get(Bill.class, Id);
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
	public boolean add(Bill t) {
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
	public boolean edit(Bill t) {
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
			Bill p = session.load(Bill.class, id);
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

	@Override
	public List<Bill> findAll(Date start, Date end) {
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Bill.class).add(Restrictions.between("tGlap", start, end));
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return null;
	}

}
