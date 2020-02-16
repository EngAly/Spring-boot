package com.fci.engaly.tutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * note that :- this tutorial explain consuming a RESTful Web Services by using
 * jQuery AJAX. controller will redirects into the HTML file to consumes the
 * RESTful web services.
 * 
 * @author engaly
 *
 */
@Controller
@RequestMapping("/jqueryConsumeRestful")
public class T9_RESTfulWithJqueryAJAX {

	@RequestMapping("/products")
	public String getProducts() {
		return "t9_viewProducts";
	}

	@RequestMapping("/addproduct")
	public String addProduct() {
		return "../t9_addProduct.html";
	}
}
