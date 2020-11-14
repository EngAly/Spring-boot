package com.example.decorator;

public class Gift extends ProductDecorator {

	public Gift(Product product) {
		super(product);
	}

	@Override
	public int getPrice() {
		return super.getPrice() + 10;
	}

}
