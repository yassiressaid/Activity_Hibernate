package com.essaid.activityApp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.essaid.activityApp.dao.ActivitiesDao;
import com.essaid.activityApp.models.Activities;

@Controller
@RequestMapping("/apprenant")
public class ApprenantController {

	@Autowired
	private ActivitiesDao activitiesDao;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String ListActivities(Model theModel) throws ClassNotFoundException, SQLException {

		List<Activities> listActivities = activitiesDao.listActivities();

		theModel.addAttribute("listActivities", listActivities);

		return "apprenant";
	}
}
