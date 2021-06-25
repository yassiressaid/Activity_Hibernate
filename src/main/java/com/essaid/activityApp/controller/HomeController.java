package com.essaid.activityApp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.essaid.activityApp.dao.ApprenantDao;
import com.essaid.activityApp.dao.ApprenantDaoImp;
import com.essaid.activityApp.dao.RoleDao;
import com.essaid.activityApp.dao.RoleDaoImp;
import com.essaid.activityApp.models.Apprenant;
import com.essaid.activityApp.models.User;
import com.essaid.activityApp.repository.UserRepository;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public ModelAndView home(HttpServletResponse response) throws IOException {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/register")
	public ModelAndView register(HttpServletResponse response) throws IOException {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/apprenant")
	public ModelAndView apprenant(HttpServletResponse response) throws IOException {
		return new ModelAndView("apprenant");
	}
	
	@RequestMapping(value = "/formateur")
	public ModelAndView formateur(HttpServletResponse response) throws IOException {
		return new ModelAndView("formateur");
	}

	@Autowired
	private UserRepository user;

	@RequestMapping(value = "/registerProsses", method = RequestMethod.GET)
	public String Register(HttpServletRequest request, HttpSession session, Model model)
			throws ServletException, IOException {
		System.out.println("App is working");
		String nom = request.getParameter("Nom");
		String prenom = request.getParameter("Prenom");
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		User users = user.getUserByEmail(email);
		if (users != null) {
			model.addAttribute("massage", "Email already exist");
			return "register";
		} else {
			RoleDao role = new RoleDaoImp();
			ApprenantDao apprenantDao = new ApprenantDaoImp();
			Apprenant apprenant = new Apprenant();
			apprenant.setNom(nom);
			apprenant.setPrenom(prenom);
			apprenant.setEmail(email);
			apprenant.setPassword(password);
			try {
				apprenant.setRole(role.getRoleById(3L));
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				apprenantDao.addApprenant(apprenant);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// T ODO Auto-generated catch block
				e.printStackTrace();
			}

			return "registerProsses";
		}
	}
}
