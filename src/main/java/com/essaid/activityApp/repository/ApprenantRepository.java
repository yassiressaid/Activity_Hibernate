package com.essaid.activityApp.repository;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.essaid.activityApp.models.Apprenant;
import com.essaid.activityApp.util.HibernateUtil;
@Repository
public class ApprenantRepository {
	Session session;
	public Apprenant getUserByEmail(String email) {
		Session session;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Apprenant as a where a.email=: email");
		query.setParameter("email", email);
		try {
			Apprenant apprenant = (Apprenant) query.getSingleResult();
			return apprenant;
		} catch (Exception e) {
			return null;
		}
	}
	
}
