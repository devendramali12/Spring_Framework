package com.tyss.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.entity.Product;
import com.tyss.exception.ProductNotFoundException;
import com.tyss.repo.ProductRepository;

@Repository
public class ProductDAO {

	@Autowired
	private ProductRepository productRepository;

	public Product findById(Integer pid) {
		return productRepository.findById(pid).orElseThrow(() -> new ProductNotFoundException("product not found"));
	}

}