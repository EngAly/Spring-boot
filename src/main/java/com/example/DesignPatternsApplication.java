package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.decorator.Runner;

@SpringBootApplication
public class DesignPatternsApplication implements CommandLineRunner {

	@Autowired
	Runner runner;

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int price = runner.getBasicProduct().getPrice();
		System.out.println(price);
		int price4gift = runner.getProductAndGift().getPrice();
		System.out.println(price4gift);

	}

}
