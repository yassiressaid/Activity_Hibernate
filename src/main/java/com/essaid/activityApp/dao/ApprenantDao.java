package com.essaid.activityApp.dao;

import java.sql.SQLException;
import java.util.List;

import com.essaid.activityApp.models.Apprenant;

public interface ApprenantDao {
	public void addApprenant(Apprenant apprenant) throws ClassNotFoundException, SQLException;

	public void updateApprenant(Apprenant apprenant) throws ClassNotFoundException, SQLException;

	public List<Apprenant> listApprenants() throws ClassNotFoundException, SQLException;

	public Apprenant getApprenantById(Long id) throws ClassNotFoundException, SQLException;

	public void removeApprenant(Long id) throws ClassNotFoundException, SQLException;
}
