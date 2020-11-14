package com.example.decorator;

import org.springframework.stereotype.Service;

@Service
public class Runner {

	public Product getBasicProduct() {
		return new BasicProduct();
	}
	
	public Product getProductAndGift() {
		return new Gift(new BasicProduct());
	}

}
