package com.fci.engaly.tutorial;

import java.util.HashMap;
import java.util.Map;

 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import com.fci.engaly.model.Product;
 
/**
 * --------------------------independent any other files-------------------------------------
 * this Controller wotrk as web service
 * this class is responsible for get all products in repository one by one
 */
@RestController
@RequestMapping("/restfulservice")
@SessionScope
public class T2_RestfulWebService {
	private static Map<String, Product> productRepo = new HashMap<>();

	/**
	 * init Product Object with group of products
	 */
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productRepo.put(honey.getId(), honey);

		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		productRepo.put(almond.getId(), almond);

		Product fruits = new Product();
		fruits.setId("3");
		fruits.setName("Fruits");
		productRepo.put(fruits.getId(), fruits);

	}

	/**
	 * Select get all products from repository and show it to browser. note that
	 * this API familiar with browser not need outer tools to test it.
	 * 
	 * @return
	 */
	@RequestMapping("/products")
	public Object getProducts() {
		return productRepo.values();
	}

	/**
	 * Need to postman => pass to this API id and it will delete product from
	 * products list note that you must test this API on external tool like
	 * Postman write in postman tool
	 * url:http://127.0.0.1:8080/service/products/3 => 3 product number that
	 * will be deleted from products list
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public Object removeProduct(@PathVariable("id") String id) {
		productRepo.remove(id);
		return productRepo.values();
	}

	/**
	 * Need to postman => insert new product to products list that found in
	 * repository
	 * 
	 * @param product
	 *            : new product details(product's id and name)
	 * @return
	 */
	@RequestMapping(value = "/newproduct", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		productRepo.put(product.getId(), product);
		return new ResponseEntity<>(productRepo, HttpStatus.CREATED);
	}

	/**
	 * Need to postman => update product content pass id that you want to update
	 * it and pass new product attribute
	 * 
	 * @param id
	 * @param product:
	 *            product object that contain same id because it primary and new
	 *            product name and result will get new product details you
	 *            didn't need to write id in body only other product details
	 * @return
	 */
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public Object updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(product.getId(), product);
		return productRepo;
	}

}
