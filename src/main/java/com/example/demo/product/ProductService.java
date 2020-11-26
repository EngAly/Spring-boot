package com.example.demo.product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.demo.wrapper.Wrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

	@PostConstruct
	private List<Product> fillProducts() {
		return Stream.of(new Product(1, "ar1", "en1"), new Product(1, "ar2", "en2"), new Product(1, "ar3", "en3"))
				.collect(Collectors.toList());
	}

	public List<Product> getAll() {
		log.warn("in get all");
		return fillProducts();
	}

	public Product getProduct(String name) {
		Wrapper<Product> temp = new Wrapper<Product>(null);
		fillProducts().forEach(product -> {
			if (product.getArName().equals(name)) {
				product.setEnName(null);
				temp.obj = product;
				return;
			} else if (product.getEnName().equals(name)) {
				product.setArName(null);
				temp.obj = product;
				return;
			}
		});
		if (temp.obj == null) {
			throw new RuntimeException("product not found");
		}
		return temp.obj;
	}

	public List<Product> getAllProduct(String name) {
		List<Product> products = new ArrayList<Product>();
		fillProducts().forEach(product -> {
			if (product.getArName().contains(name)) {
				product.setEnName(null);
				products.add(product);
			} else if (product.getEnName().contains(name)) {
				product.setArName(null);
				products.add(product);
			}
		});
		if (products == null || products.isEmpty()) {
			throw new RuntimeException("product not found");
		}
		return products;
	}

}
