package com.reponsitory.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Flight;
import com.model.TicketDetail;
import com.reponsitory.TicketDetailReponsitory;

@Repository
public class TicketDetailsReponsitoryImp implements TicketDetailReponsitory {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TicketDetail> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			List<TicketDetail> list = session.createCriteria(TicketDetail.class).list();
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
	public List<TicketDetail> findAll(int position, int pageSize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(TicketDetail.class);
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
	public List<TicketDetail> findAll(Flight maChuyenBay) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(TicketDetail.class)
					.add(Restrictions.eq("maChuyenBay", maChuyenBay));
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
			count = (Long) session.createCriteria(TicketDetail.class).setProjection(Projections.rowCount())
					.uniqueResult();
		} else {
			count = (Long) session.createCriteria(TicketDetail.class).setProjection(Projections.rowCount())
					.add(Restrictions.like("loaiVe", "%" + name + "%")).uniqueResult();
		}
		return count;
	}

	@Override
	public TicketDetail getById(Integer Id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			TicketDetail c = (TicketDetail) session.get(TicketDetail.class, Id);
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
	public boolean add(TicketDetail t) {
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
	public boolean edit(TicketDetail t) {
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
			TicketDetail p = session.load(TicketDetail.class, id);
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
	public Long countTotalRecords() {
		Session session = sessionFactory.openSession();
		Long count;
		count = (Long) session.createCriteria(TicketDetail.class).setProjection(Projections.rowCount()).uniqueResult();
		return count;
	}

}
