package com.essaid.activityApp.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.essaid.activityApp.models.Formateur;
import com.essaid.activityApp.util.HibernateUtil;

@Repository
public class FormatuerDaoImp implements FormateurDao {

	@Override
	public void addFormateur(Formateur formateur) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			RoleDao role = new RoleDaoImp();
			formateur.setRole(role.getRoleById(2L));
			session.saveOrUpdate(formateur);
			transaction.commit();
			System.out.println("Formateur est bien crée !");
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
	public void updateFormateur(Formateur formateur) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(formateur);
			transaction.commit();
			System.out.println("Formateur est bien modifier !");
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
	public List<Formateur> listApprenants() throws ClassNotFoundException, SQLException {
		Session session = null;
		List<Formateur> formateurs = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Query query = session.getNamedQuery("Formateur.All");
			formateurs = query.list();

			System.out.println("Formateurs lu !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return formateurs;
	}

	@Override
	public Formateur getFormateurById(Long id) throws ClassNotFoundException, SQLException {
		Formateur formateur = null;
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();

			formateur = (Formateur) session.get(Formateur.class, id);
			System.out.println("Formateur is get !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return formateur;
	}

	@Override
	public void removeFormateur(Long id) throws ClassNotFoundException, SQLException {
		Formateur formateur = getFormateurById(id);
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.delete(formateur);
			transaction.commit();
			System.out.println("Formateur supprimé !");

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
