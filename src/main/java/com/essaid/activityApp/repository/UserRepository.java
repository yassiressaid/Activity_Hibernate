package com.essaid.activityApp.repository;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.essaid.activityApp.models.User;
import com.essaid.activityApp.util.HibernateUtil;
@Repository
public class UserRepository {
	public User getUserByEmail(String email) {
		Session session;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User as u where u.email=: email");
		query.setParameter("email", email);
		try {
			User user = (User) query.getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}
}
