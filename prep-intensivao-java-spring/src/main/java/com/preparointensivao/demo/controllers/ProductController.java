package com.preparointensivao.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preparointensivao.demo.entities.Product;
import com.preparointensivao.demo.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product> getObjects() {		
		
//		create to populate H2
//		Department d1 = new Department(1L, "Tech");
//		Department d2 = new Department(2L, "Pet");
//	
//		Product p1 = new Product(1L, "Macbook Pro", 4000.0, d1);
//		Product p2 = new Product(2L, "PC Gamer", 5000.0, d1);
//		Product p3 = new Product(3L, "Pet House", 300.0, d2);
		
		List<Product> list = productRepository.findAll();
		return list;
	}
}
