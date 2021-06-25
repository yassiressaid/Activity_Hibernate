package com.essaid.activityApp.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@NamedQuery(query = "SELECT t FROM Admin t", name = "Admin.All")
@PrimaryKeyJoinColumn(name = "id_user")
public class Admin extends User {

	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;

	public Admin(String nom, String prenom, String email, String password, Role role) {
		super(nom, prenom, email, password, role);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
