package com.essaid.activityApp.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@NamedQuery(query = "SELECT t FROM Apprenant t", name = "Apprenant.All")
@PrimaryKeyJoinColumn(name = "id_user")
public class Apprenant extends User {

	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;

	public Apprenant(String nom, String prenom, String email, String password, Role role) {
		super(nom, prenom, email, password, role);
	}

	public User getUser() {
		return user;
	}

	public Apprenant() {
		super();
	}

	public void setUser(User user) {
		this.user = user;
	}

}
