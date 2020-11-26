package com.example.demo.product;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDTO;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("products")
	public List<Product> getAll() {
		return service.getAll();
	}

	@GetMapping("product/{name}")
	public ProductDTO getProduct(@PathVariable("name") String name) {
		return mapper.map(service.getProduct(name), ProductDTO.class);
	}

	@GetMapping("products/{name}")
	public List<ProductDTO> getAllProducts(@PathVariable("name") String name) {
		return service.getAllProduct(name).stream().map(product -> mapper.map(product, ProductDTO.class))
				.collect(Collectors.toList());
	}
}
