package com.tyss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import com.tyss.service.ProductService;

@RestController
@RequestMapping("/pds")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	// fetchAll
	@GetMapping
	public List<Product> fetchAll() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@GetMapping("/by")
	public Product productById(@RequestParam Integer pid) {
		return productService.getById(pid);
	}

	// save
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

		Product saved = productRepository.save(product);

		ResponseEntity<Product> resp = new ResponseEntity<Product>(saved, HttpStatus.CREATED);

		return resp;
	}

	@DeleteMapping("/d/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {

		Optional<Product> opt = productRepository.findById(id);

		if (opt.isPresent()) {
			productRepository.deleteById(id);
//			return ResponseEntity.status(HttpStatus.OK).body("Product Deleted");
			return ResponseEntity.ok("Product Deleted");
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product Not found");
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

	// pagination
	@GetMapping("/page")
	public List<Product> getProductsBypage(@RequestParam Integer pageNumber) {

		Pageable pageable = PageRequest.of(pageNumber - 1, 15);

		Page<Product> page = productRepository.findAll(pageable);

		return page.toList();
	}

	// sorting
	@GetMapping("/sort")
	public List<Product> sortProducts(@RequestParam String param) {

		List<Product> products = productRepository.findAll(Sort.by(param).descending());

		return products;
	}

	// filter
	@GetMapping("/filter")
	public List<Product> filterProducts(@RequestBody Product product) {

		Example<Product> of = Example.of(product);// entity object

		List<Product> all = productRepository.findAll(of);

		return all;
	}

	@GetMapping("/byPrice")
	public List<Product> fetchByPrice(@RequestParam Double price) {

		List<Product> products = productRepository.findByPriceIsLessThanEqual(price);

		return products;
	}

	@GetMapping("/custom")
	public List<Product> fetchByPrice(@RequestParam Double price, @RequestParam String cat) {

		List<Product> products = productRepository.findByPriceAndCategory(price, cat);

		return products;
	}

	@GetMapping("/search")
	public List<Product> getByName(@RequestParam String name) {

		List<Product> products = productRepository.findByNameContainingAllIgnoreCase(name);

		return products;
	}

	@PostMapping(value = "/content", consumes = { "application/xml", "application/json" }, produces = {
			"application/xml", "application/json" })
	public Product content(@RequestBody Product product) {
		System.out.println("recieved");
		return product;
	}

	@GetMapping("/exc")
	public String exc() {

		System.out.println("Hello");

//		String s = "";

//		System.out.println(s.charAt(0));//NPE

		int a = 10 / 0;// ArithmeticException

		System.out.println("Hiii");

		return "Welcome to API";
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handlNullPointerException(NullPointerException e) {
		System.out.println("Handled NullPointerException in Product Controller");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> handlAE(ArithmeticException e) {
		System.out.println("Handled AE in Product Controller");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

}