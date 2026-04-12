
package com.tyss.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@GetMapping("/fetch")
	public String fetch() {
		return "Product Fetched";
	}

	@PostMapping("/save")
	public String save() {
		return "Product saved";
	}

	@PutMapping("/update")
	public String upate() {
		return "Product Updated";
	}

	@DeleteMapping("/delete")
	public String delete() {
		return "Product Deleted";
	}

}
