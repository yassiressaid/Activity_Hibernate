package com.essaid.activityApp.dao;

import java.sql.SQLException;
import java.util.List;

import com.essaid.activityApp.models.Activities;

public interface ActivitiesDao {

	public void addActivity(Activities activities) throws ClassNotFoundException, SQLException;

	public void updateActivity(Activities activities) throws ClassNotFoundException, SQLException;

	public List<Activities> listActivities() throws ClassNotFoundException, SQLException;

	public Activities getActivityById(Long id) throws ClassNotFoundException, SQLException;

	public void removeActivity(Long id) throws ClassNotFoundException, SQLException;
}
