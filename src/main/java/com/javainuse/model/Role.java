package com.javainuse.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(unique = true, length = 120)
	private String role;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "roles")
	private List<User> users = new ArrayList<>();

	public Role() {
	}

	public Role(String role) {
		this.role = role;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	@JsonIgnore
	public List<User> getUsers() {
		return users;
	}

	
	public void setUser(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[id=").append(id).append(", role=").append(role).append("]");
		return builder.toString();
	}

}
