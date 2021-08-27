package com.saleproduct.service;

import java.util.List;



import com.saleproduct.entity.Product;


public interface ProductService  {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategory(String cid);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);
	
}
