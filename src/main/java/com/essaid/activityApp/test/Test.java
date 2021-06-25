package com.essaid.activityApp.test;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.essaid.activityApp.dao.ApprenantDao;
import com.essaid.activityApp.dao.ApprenantDaoImp;
import com.essaid.activityApp.dao.FormateurDao;
import com.essaid.activityApp.dao.FormatuerDaoImp;
import com.essaid.activityApp.dao.RoleDao;
import com.essaid.activityApp.dao.RoleDaoImp;
import com.essaid.activityApp.models.Apprenant;
import com.essaid.activityApp.models.Formateur;
import com.essaid.activityApp.models.Role;

public class Test {
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		RoleDao role = new RoleDaoImp();
		FormateurDao formateurDao = new FormatuerDaoImp();
//		ReservationDao resDao = new ReservationDaoImp();
//		Configuration con = new Configuration().configure();
//		SessionFactory sf = con.buildSessionFactory();
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//		Reservation reservation = new Reservation();
//		reservation.setApprenant(apprenant);
//		resDao.addReservation(reservation);
////		
		Formateur user = new Formateur();
		user.setNom("Essaid");
		user.setPrenom("Abdo");
		user.setEmail("Abdo@gmail.com");
		user.setPassword("123456");
		user.setRole(role.getRoleById(2L));
		formateurDao.addFormateur(user);
//		Role rol = new Role();
//		rol.setRole("Apprenant");
//		role.addRole(rol);
		
//		session.save(user);
//		tx.commit();
////		TypeReservationDao type = new TypeReservationDaoImp();
////		TypeReservation typeReservation = new TypeReservation();
////		typeReservation.setType_reservation("Week-end");
////		typeReservation.setNombre_apprenant(20);
////		type.addType(typeReservation);
//		
//		AdministrateurDao dao = new AdministrateurDaoImp();
//		Administrateur administrateur = new Administrateur();
//		administrateur.setNom("Hala");
//		administrateur.setPrenom("bala");
//		administrateur.setEmail("bala@gmail.com");
//		administrateur.setPassword("1234567");
//		administrateur.setRole(role.getRoleById(3L));
//		dao.addAdministrateur(administrateur);
//		
//	}
		
		
	}
}
