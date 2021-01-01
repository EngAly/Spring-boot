package com.example.demo.brand;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Language implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String code;

	@OneToMany(mappedBy = "lang", cascade = CascadeType.ALL)
 	@JsonIgnore
	private Collection<BrandLocalization> sales = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Collection<BrandLocalization> getSales() {
		return sales;
	}

	public void setSales(Collection<BrandLocalization> sales) {
		this.sales = sales;
	}
}