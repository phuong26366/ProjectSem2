package com.reponsitory.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.Airstrip;
import com.reponsitory.AirstripReponsitory;

@Repository
public class AirstripReponsitoryImp implements AirstripReponsitory{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Airstrip> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			List<Airstrip> list = session.createCriteria(Airstrip.class).list();
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
	public List<Airstrip> findAll(int position, int pageSize) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Airstrip.class);
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
	public List<Airstrip> findAll(int position, int pageSize, String name) {
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Airstrip.class).add(Restrictions.like("viTri", "%" + name + "%"));
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
			count = (Long) session.createCriteria(Airstrip.class).setProjection(Projections.rowCount()).uniqueResult();
		} else {
			count = (Long) session.createCriteria(Airstrip.class).setProjection(Projections.rowCount())
					.add(Restrictions.like("viTri", "%" + name + "%")).uniqueResult();
		}
		return count;
	}

	@Override
	public Airstrip getById(Integer Id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Airstrip c = (Airstrip) session.get(Airstrip.class, Id);
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
	public boolean add(Airstrip t) {
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
	public boolean edit(Airstrip t) {
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
			Airstrip p = session.load(Airstrip.class, id);
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
