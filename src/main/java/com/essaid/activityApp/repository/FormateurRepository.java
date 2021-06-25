package com.essaid.activityApp.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.essaid.activityApp.models.Activities;
import com.essaid.activityApp.models.Formateur;
import com.essaid.activityApp.models.TypeActivity;
import com.essaid.activityApp.util.HibernateUtil;
@Repository
public class FormateurRepository {
	Session session;
	public Formateur getUserByEmail(String email) {
		Session session;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Formateur as a where a.email=: email");
		query.setParameter("email", email);
		try {
			Formateur formateur = (Formateur) query.getSingleResult();
			return formateur;
		} catch (Exception e) {
			return null;
		}
	}
	public TypeActivity getByType(String type) {
		Session session;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from TypeActivity as t where t.type_activity=: type");
		query.setParameter("type", type);
		try {
			TypeActivity typeActivity = (TypeActivity) query.getSingleResult();
			return typeActivity;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Activities> listById(long id) {
		Session session;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Activities as t where t.id_user=: id");
		query.setParameter("id", id);
		try {
			@SuppressWarnings("unchecked")
			List<Activities> reserve = query.getResultList();
			return reserve;
		} catch (Exception e) {
			return null;
		}
	}
	
//	public Reservation count(Date newdate) {
//		Session session;
//		session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		Query query = session.createQuery("FROM Reservation as r where r.date LIMIT newdate");
//		query.setParameter("newdate", newdate);
//		try {
//			Reservation reservation = (Reservation) query.getSingleResult();
//			return reservation;
//		} catch (Exception e) {
//			return null;
//		}
		
	
}
