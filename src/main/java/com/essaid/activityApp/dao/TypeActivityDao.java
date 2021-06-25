package com.essaid.activityApp.dao;

import java.sql.SQLException;
import java.util.List;

import com.essaid.activityApp.models.TypeActivity;

public interface TypeActivityDao {

	public void addTypeActivity(TypeActivity typeActivity) throws ClassNotFoundException, SQLException;

	public void updateTypeActivity(TypeActivity typeActivity) throws ClassNotFoundException, SQLException;

	public List<TypeActivity> listTypeActivities() throws ClassNotFoundException, SQLException;

	public TypeActivity getTypeActivityrById(Long id) throws ClassNotFoundException, SQLException;

	public void removeTypeActivity(Long id) throws ClassNotFoundException, SQLException;
}
