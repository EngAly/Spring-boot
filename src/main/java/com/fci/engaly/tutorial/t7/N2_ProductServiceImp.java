package com.fci.engaly.tutorial.t7;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fci.engaly.model.Product;

/**
 * Observe that in this tutorial, we are using Product Service API(s) to store,
 * retrieve, update and delete the products. We wrote the business logic
 * in @RestController class file itself. Now, we are moved the business logic
 * code from controller to service component.
 * 
 * we created an Interface which contains add, edit, get and delete methods t7
 * => N1_* using the code observe that => @Service annotation and write in it
 * the business logic instead of to store, retrieve, delete and updates the
 * product.
 * 
 * @author engaly
 *
 */
@Service
public class N2_ProductServiceImp implements N1_ProductService {

	private static Map<String, Product> productRepo = new HashMap<>();
	static {
		Product toothpaste = new Product();
		toothpaste.setId("20");
		toothpaste.setName("toothpaste");
		productRepo.put(toothpaste.getId(), toothpaste);

		Product eatables = new Product();
		eatables.setId("21");
		eatables.setName("eatables");
		productRepo.put(eatables.getId(), eatables);

		Product textiles = new Product();
		textiles.setId("22");
		textiles.setName("textiles");
		productRepo.put(textiles.getId(), textiles);
	}

	@Override
	public void createProduct(Product product) {
		productRepo.put(product.getId(), product);

	}

	@Override
	public void updateProduct(String id, Product product) {
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);

	}

	@Override
	public void deleteProduct(String id) {
		productRepo.remove(id);
	}

	@Override
	public Collection<Product> getProducts() {
		return productRepo.values();
	}

}
