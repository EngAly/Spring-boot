package com.fci.engaly.tutorial;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fci.engaly.model.Product;

@RestController
public class T11_HoldFormData {

	@RequestMapping(value = "/formController", method = RequestMethod.POST)
	public Object getFormData(Product product) {
		if (!(product.getId().isEmpty() || product.getName().isEmpty())) {
			return product;
		}
		return (Object) "<h1 style='color:red'>all fields must be is filled</h1>";

	}

}
