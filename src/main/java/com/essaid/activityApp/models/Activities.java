package com.essaid.activityApp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(query = "SELECT t FROM Activities t", name = "activities.All")
public class Activities {

	@Id
	@GeneratedValue
	@Column(name = "id_activity")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private Formateur formateur;

	@ManyToOne
	@JoinColumn(name = "activities")
	private TypeActivity type;

	@Temporal(TemporalType.DATE)
	private Date date;

	public Activities(Formateur formateur, TypeActivity type, Date date) {
		super();
		this.formateur = formateur;
		this.type = type;
		this.date = date;
	}

	public Activities() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public TypeActivity getType() {
		return type;
	}

	public void setType(TypeActivity type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
