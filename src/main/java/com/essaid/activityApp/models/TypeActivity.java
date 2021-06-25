package com.essaid.activityApp.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(query = "SELECT t FROM TypeActivity t", name = "TypeActivity.All")
@Table(name = "type_activity")
public class TypeActivity {

	@Id
	@GeneratedValue
	@Column(name = "id_type")
	private Long id;
	private String type_activity;
	@OneToMany
	@JoinColumn(name = "id_activity")
	private List<Activities> activities;

	public TypeActivity(String type_activity) {
		super();
		this.type_activity = type_activity;
	}

	public TypeActivity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType_activity() {
		return type_activity;
	}

	public void setType_activity(String type_activity) {
		this.type_activity = type_activity;
	}

	public List<Activities> getActivities() {
		return activities;
	}

	public void setActivities(List<Activities> activities) {
		this.activities = activities;
	}

	@Override
	public String toString() {
		return "TypeActivity [id=" + id + ", type_activity=" + type_activity + ", activities=" + activities + "]";
	}

}
