package com.tyss.dao;

import org.springframework.stereotype.Repository;

import com.tyss.entity.Product;
import com.tyss.repo.ProductRepository;

@Repository
public class ProductDAO {

	private ProductRepository productRepository;

	public Product findById(Integer pid) {
		return productRepository.findById(pid).orElseThrow(() -> new RuntimeException("Product not found"));
	}
}
