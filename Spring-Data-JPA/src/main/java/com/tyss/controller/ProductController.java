package com.tyss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.entity.Product;
import com.tyss.repo.ProductRepository;

@RestController
@RequestMapping("/pds")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	// fetchAll
	@GetMapping
	public List<Product> fetchAll() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@GetMapping("/by")
	public Product productById(@RequestParam Integer pid) {

//		Optional<Product> opt = productRepository.findById(pid);

//		if (opt.isPresent()) {
//			Product product = opt.get();
//			return product;
//		}
//		return null;

//		if (opt.isPresent()) {
//			return opt.get();
//		} else {
//			throw new RuntimeException();
//		}

		return productRepository.findById(pid).orElseThrow(() -> new RuntimeException("Product not found"));

	}

	// save
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		Product saved = productRepository.save(product);
		return saved;
	}

	@DeleteMapping("/d/{id}")
	public String deleteProduct(@PathVariable Integer id) {

		Optional<Product> opt = productRepository.findById(id);

		if (opt.isPresent()) {
			productRepository.deleteById(id);
			return "Product Deleted";
		}
		return "Not found";
	}

	@PutMapping("/update/{id}")
	public String updateProductPrice(@PathVariable Integer id, @RequestParam Double price) {

		Optional<Product> opt = productRepository.findById(id);

		if (opt.isPresent()) {
			Product product = opt.get();
			product.setPrice(price);

			productRepository.save(product);

			return "Price updated";
		}

		return "Product not found";
	}
}