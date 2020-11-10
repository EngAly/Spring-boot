package com.example.singletable.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ANIMAL")
public class Animals extends Species {

	private Double width;

	public Animals() {
	}

	public Animals(String color,Double width) {
		super(color);
		this.width = width;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

}
