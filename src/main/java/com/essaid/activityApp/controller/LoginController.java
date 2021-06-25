package com.essaid.activityApp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.essaid.activityApp.models.Apprenant;
import com.essaid.activityApp.models.Formateur;
import com.essaid.activityApp.models.User;
import com.essaid.activityApp.repository.ApprenantRepository;
import com.essaid.activityApp.repository.FormateurRepository;
import com.essaid.activityApp.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private UserRepository user;
	@Autowired
	private ApprenantRepository apprenant;
	@Autowired
	private FormateurRepository formateur;
	Session session;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpSession session, Model model) {
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		User users = user.getUserByEmail(email);
		Apprenant apprenants = apprenant.getUserByEmail(email);
		Formateur formateurs = formateur.getUserByEmail(email);
	
		if (users != null && users.getPassword().equals(password)) {
			session.setAttribute("formateur", formateurs);
			if (users.getRole().getRole().equals("Formateur")) {
				model.addAttribute("Nom", users.getNom());
				model.addAttribute("Prenom", users.getPrenom());
				return "redirect:/formateur";
			} else if (apprenants != null && apprenants.getRole().getRole().equals("Apprenant")) {
				model.addAttribute("Nom", apprenants.getNom());
				model.addAttribute("Prenom", apprenants.getPrenom());
				return "redirect:/apprenant";
			}
		} else {
			User user = new User();
			model.addAttribute("user", user);
			model.addAttribute("msg", "Email or Password incorrect");
			return "home";
		}
		System.out.println("Not working");
		return "home";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
