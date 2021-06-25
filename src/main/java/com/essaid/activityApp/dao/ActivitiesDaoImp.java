package com.essaid.activityApp.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.essaid.activityApp.models.Activities;
import com.essaid.activityApp.util.HibernateUtil;

@Repository
public class ActivitiesDaoImp implements ActivitiesDao{

	@Override
	public void addActivity(Activities activities) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(activities);
			transaction.commit();
			System.out.println("activity est bien crée !");
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
	public void updateActivity(Activities activities) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(activities);
			transaction.commit();
			System.out.println("activity est bien modifier !");
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
	public List<Activities> listActivities() throws ClassNotFoundException, SQLException {
		Session session = null;
		List<Activities> activities = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Query query = session.getNamedQuery("activities.All");
			activities = query.list();

			System.out.println("activities lu !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return activities;
	}

	@Override
	public Activities getActivityById(Long id) throws ClassNotFoundException, SQLException {
		Activities activities = null;
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			
			activities = (Activities) session.get(Activities.class, id);
			System.out.println("Activity is get !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return activities;
	}

	@Override
	public void removeActivity(Long id) throws ClassNotFoundException, SQLException {
		Activities activities = getActivityById(id);
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.delete(activities);
			transaction.commit();
			System.out.println("Activity supprimé !");

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
