package com.essaid.activityApp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@NamedQuery(query = "SELECT t FROM Formateur t", name = "Formateur.All")
@PrimaryKeyJoinColumn(name = "id_user")
public class Formateur extends User {

	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;

	@OneToMany(mappedBy = "formateur")
	private List<Activities> activities;

	public Formateur(String nom, String prenom, String email, String password, Role role) {
		super(nom, prenom, email, password, role);
	}

	public Formateur() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Activities> getActivities() {
		return activities;
	}

	public void setActivities(List<Activities> activities) {
		this.activities = activities;
	}

}
