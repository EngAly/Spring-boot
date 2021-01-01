package com.example.demo.brand;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BrandLocalization implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EntityLocaleId brandLocale = new EntityLocaleId();

	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("entityId")
	@JoinColumn(name = "brand_id")
	@JsonIgnore
	private Brand brand;

	@ManyToOne
	@MapsId("langId")
	@JoinColumn(name = "lang_id")
	private Language lang;

	private String name;

	private String description;

	public EntityLocaleId getBrandLocale() {
		return brandLocale;
	}

	public void setBrandLocale(EntityLocaleId brandLocale) {
		this.brandLocale = brandLocale;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Language getLang() {
		return lang;
	}

	public void setLang(Language lang) {
		this.lang = lang;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}