package com.saleproduct.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saleproduct.dao.ProductDAO;
import com.saleproduct.entity.Product;
import com.saleproduct.service.ProductService;
@Service
public class ProductServiceimpl implements ProductService {
	@Autowired
	 ProductDAO pdao;

	@Override
	public List<Product> findAll() {
		return pdao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		return pdao.findById(id).get();
	}

	@Override
	public List<Product> findByCategory(String cid) {
		return pdao.findByCategory(cid);
	}

	@Override
	public Product create(Product product) {
		return pdao.save(product);
	}

	@Override
	public Product update(Product product) {

		return pdao.save(product);
	}

	@Override
	public void delete(Integer id) {
		 pdao.deleteById(id);;
	}
}
