package com.tyss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.dao.ProductDAO;
import com.tyss.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public Product getById(Integer pid) {
		return productDAO.findById(pid);
	}

}
