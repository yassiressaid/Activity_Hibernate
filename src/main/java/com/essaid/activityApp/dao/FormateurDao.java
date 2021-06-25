package com.essaid.activityApp.dao;

import java.sql.SQLException;
import java.util.List;

import com.essaid.activityApp.models.Formateur;

public interface FormateurDao {

	public void addFormateur(Formateur formateur) throws ClassNotFoundException, SQLException;

	public void updateFormateur(Formateur formateur) throws ClassNotFoundException, SQLException;

	public List<Formateur> listApprenants() throws ClassNotFoundException, SQLException;

	public Formateur getFormateurById(Long id) throws ClassNotFoundException, SQLException;

	public void removeFormateur(Long id) throws ClassNotFoundException, SQLException;
}
