package com.tyss.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.entity.Product;

// --> Entity , Datatype of PK
public interface ProductRepository extends JpaRepository<Product, Integer> {

	// --> Custom Queries
//	@Query("SELECT p FROM Product p WHERE p.price=?1") // --> index based parameter
	@Query("SELECT p FROM Product p WHERE p.price=:price") // naming based parameter
	public List<Product> getProductByPrice(Double price);

	@Query("SELECT p FROM Product p WHERE p.price=:price AND p.category=:cat") // naming based parameter
	public List<Product> getProductByPriceAndCat(Double price, String cat);

	// --> Custom Methods
	public List<Product> findByPriceIsLessThanEqual(Double price);

	public List<Product> findByPriceAndCategory(Double price, String category);

//	public List<Product> findByNameContainsAllIgnoreCase(String name);

	public List<Product> findByNameContainingAllIgnoreCase(String name);

}