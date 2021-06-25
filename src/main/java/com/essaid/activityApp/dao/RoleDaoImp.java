package com.essaid.activityApp.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.essaid.activityApp.models.Role;
import com.essaid.activityApp.util.HibernateUtil;

@Repository
public class RoleDaoImp implements RoleDao{

	@Override
	public void addRole(Role role) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(role);
			transaction.commit();
			System.out.println("Role est bien crée !");
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
	public void updateRole(Role role) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(role);
			transaction.commit();
			System.out.println("Role est bien modifier !");
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

	@SuppressWarnings("rawtypes")
	public List<Role> listRoles() throws ClassNotFoundException, SQLException {
		Session session = null;
		List<Role> role = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Query query = session.getNamedQuery("Role.All");
			role = query.list();

			System.out.println("roles lu !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return role;
	}

	@Override
	public Role getRoleById(Long id) throws ClassNotFoundException, SQLException {
		Role role = null;
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			
			role = (Role) session.get(Role.class, id);
			System.out.println("Role is get !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return role;
	}

	@Override
	public void removeRole(Long id) throws ClassNotFoundException, SQLException {
		Role role = getRoleById(id);
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.delete(role);
			transaction.commit();
			System.out.println("Role supprimé !");

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
