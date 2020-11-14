package com.example.decorator;

public class ProductDecorator implements Product {

	private Product product;

	public ProductDecorator(Product product) {
		this.product = product;
	}

	@Override
	public int getPrice() {
		return this.product.getPrice();
	}

}
