package com.example.singletable.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("HUMAN")
public class Human extends Species {

	private Double height;

	public Human() {
	}
	
	public Human(String color, Double height) {
		super(color);
		this.height = height;

	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

}
