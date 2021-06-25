package com.essaid.activityApp.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.essaid.activityApp.models.TypeActivity;
import com.essaid.activityApp.util.HibernateUtil;

@Repository
public class TypeActivityDaoImp implements TypeActivityDao{

	@Override
	public void addTypeActivity(TypeActivity typeActivity) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(typeActivity);
			transaction.commit();
			System.out.println("Type activity est bien crée !");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	@Override
	public void updateTypeActivity(TypeActivity typeActivity) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(typeActivity);
			transaction.commit();
			System.out.println("Type activity est bien modifier !");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	@Override
	public List<TypeActivity> listTypeActivities() throws ClassNotFoundException, SQLException {
		Session session = null;
		List<TypeActivity> typeActivities = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Query query = session.getNamedQuery("TypeActivity.All");
			typeActivities = query.list();

			System.out.println("Type Activities lu !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return typeActivities;
	}

	@Override
	public TypeActivity getTypeActivityrById(Long id) throws ClassNotFoundException, SQLException {
		TypeActivity typeActivity = null;
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();

			typeActivity = (TypeActivity) session.get(TypeActivity.class, id);
			System.out.println("TypeActivity is get !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return typeActivity;
	}

	@Override
	public void removeTypeActivity(Long id) throws ClassNotFoundException, SQLException {
		TypeActivity typeReservation = getTypeActivityrById(id);
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.delete(typeReservation);
			transaction.commit();
			System.out.println("Type Activity supprimé !");

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
