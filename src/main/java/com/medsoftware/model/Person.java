package com.medsoftware.model;

import java.util.List;

public class Person {

	private String id;
	private String firstName;
	private String secondName;
	private List<Address> address;

	public Person(String firstName, String secondName, List<Address> address) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + "]";
	}

}
