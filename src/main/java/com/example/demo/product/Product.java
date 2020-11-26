package com.example.demo.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor   // annotate field with @nonNull
@ToString
public class Product {

	private int id;
	private String name;

	private String arName;

	private String enName;

	public Product(int id, String arName, String enName) {
		this.id = id;
		this.arName = arName;
		this.enName = enName;
	}

}
