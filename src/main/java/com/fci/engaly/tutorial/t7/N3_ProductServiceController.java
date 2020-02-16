package com.fci.engaly.tutorial.t7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fci.engaly.model.Product;

/**
 * The code here show the Rest Controller class file, here we @Autowired the
 * ProductService interface and called the methods. note that what you seek for
 * is to abstract controller about business logic so you can modify your
 * business logic as you want and wrap it in Controller this is final stage in
 * this tutorial.
 */

@RestController
@RequestMapping("/productservice")
public class N3_ProductServiceController {

	@Autowired
	N1_ProductService productService;

	/**
	 * get all products stored in repository
	 * 
	 * @return : retuen all products
	 */
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<Object> getProducts() {
		return new ResponseEntity<Object>(productService.getProducts(), HttpStatus.OK);
	}

	/**
	 * add new product waping create product method contained in @service class
	 * in restful API
	 * 
	 * @param product:
	 *            will send it in body use postman tool or use form
	 * @return: will return all product in repository
	 */
	@RequestMapping(value = "/newproduct", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		productService.createProduct(product);
		return new ResponseEntity<Object>(getProducts(), HttpStatus.CREATED);
	}

	// @RequestMapping(value = "/name", method = RequestMethod.POST)
	// public ResponseEntity<String> getname(String fname) {
	// return new ResponseEntity<String>(fname, HttpStatus.OK);
	// }

	/**
	 * update specific product via its id and send product details in product
	 * body
	 * 
	 * @param id:
	 *            send id in http url
	 * @param product:send
	 *            product details in body use postman tool or use form
	 * @return: will return all products after update the specific product via
	 *          its id
	 */
	@RequestMapping(value = "/updateproduct/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
		productService.updateProduct(id, product);
		return new ResponseEntity<Object>(getProducts(), HttpStatus.OK);
	}

	/**
	 * delete specific product from repository with passed id in url
	 * 
	 * @param id:
	 *            url that via it will delete product from repository
	 * @return
	 */
	@RequestMapping(value = "/deleteproduct/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
		productService.deleteProduct(id);
		return new ResponseEntity<Object>(getProducts(), HttpStatus.OK);
	}
}
