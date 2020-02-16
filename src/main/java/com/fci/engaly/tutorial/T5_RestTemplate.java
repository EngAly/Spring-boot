package com.fci.engaly.tutorial;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fci.engaly.model.Product;

/**
 * dependant on T2_RestfulWebService methods note all URL in exchange method
 * Rest Template is used to create applications that consume RESTful Web
 * Services. You can use the exchange() method to consume the web services for
 * all HTTP methods.
 */
@RestController
@RequestMapping("/resttemplate")
public class T5_RestTemplate {

	@Autowired
	RestTemplate restTemplate;
	private static Map<String, Product> productRepo = new HashMap<>();

	// initiate Product Object with group of products
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
	 * HttpEntity => is a helper object which encapsulates header and body of an
	 * HTTP request or response. It can be used as a handler method parameter.
	 * 
	 * @return response as entity
	 */
	@RequestMapping("products")
	public String getProducts() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		// requestEntity the entity (headers and/or body) to write to the
		// request
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate
				.exchange("http://localhost:8080/restfulservice/products", HttpMethod.GET, entity, String.class)
				.getBody();
	}

	@RequestMapping("createProduct")
	public String addNewProduct(@RequestBody Product product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		// requestEntity the entity (headers and/or body) to write to the
		// request
		HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);
		return restTemplate
				.exchange("http://localhost:8080/restfulservice/newproduct", HttpMethod.POST, entity, String.class)
				.getBody();

	}

	/**
	 * you can applay RestTemplate to all other HttpMethods(PUT,DELETE)
	 */

}
