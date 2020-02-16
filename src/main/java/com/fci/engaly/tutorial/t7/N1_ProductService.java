package com.fci.engaly.tutorial.t7;

import java.util.Collection;

import com.fci.engaly.model.Product;

public interface N1_ProductService {

	
	public void createProduct(Product product);	
	public void updateProduct(String id,Product product);
	public void deleteProduct(String id);
	public Collection<Product> getProducts();
	
}
