package com.essaid.activityApp.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.essaid.activityApp.dao.ActivitiesDao;
import com.essaid.activityApp.dao.ActivitiesDaoImp;
import com.essaid.activityApp.models.Activities;
import com.essaid.activityApp.models.Formateur;
import com.essaid.activityApp.models.TypeActivity;
import com.essaid.activityApp.repository.FormateurRepository;

@Controller
@RequestMapping("/formateur")
public class FormateurController {

	@Autowired
	private FormateurRepository typeActivity;
	@Autowired
	private FormateurRepository activity;
	Session session;
	@Autowired
	private ActivitiesDao activitiesDao;
	
	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpSession session, Model model) throws ClassNotFoundException, SQLException, ParseException {
		Formateur formateur = (Formateur) session.getAttribute("formateur");
		String date = request.getParameter("date");
		Date newdate = Date.valueOf(date);
		String type = request.getParameter("type");
		System.out.println("formateur Objet");
		System.out.println(formateur);
		TypeActivity typeActiv = typeActivity.getByType(type);
//		Reservation countReserv = reservation.count(newdate);
//		System.out.println(countReserv);
		ActivitiesDao actDao = new ActivitiesDaoImp();
		System.out.println(typeActiv);
		
		Activities activities = new Activities();
		activities.setFormateur(formateur);
		activities.setType(typeActiv);
		activities.setDate(newdate);
		
		actDao.addActivity(activities);
		return "formateur";

	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ListActivities(Model theModel) throws ClassNotFoundException, SQLException {
		
		List<Activities> listActivities = activitiesDao.listActivities();

		theModel.addAttribute("listActivities", listActivities);

		return "formateur";
	}
//	@RequestMapping(value = "/apprenant", method = RequestMethod.GET)
//	public String apprenantReserve(HttpServletRequest request, HttpSession session, Model theModel) throws ClassNotFoundException, SQLException {
//		Apprenant apprenants = (Apprenant) session.getAttribute("apprenant");
//		Reservation listReserve =  (Reservation) reservation.listById(apprenants.getId());
//		theModel.addAttribute("listReserve", listReserve);
//		return "redirect:/apprenant";
//	}
}
