package com.example.demo.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandController {

	@Autowired
	private BrandService brandService;

	@PostMapping("/brands")
	public Brand saveBrand(@RequestBody Brand brand) {
		return brandService.saveBand(brand);
	}
}
