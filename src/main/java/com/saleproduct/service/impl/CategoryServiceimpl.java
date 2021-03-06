package com.saleproduct.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saleproduct.dao.CategoryDAO;
import com.saleproduct.entity.Category;
import com.saleproduct.service.CategoryService;

@Service
public class CategoryServiceimpl implements CategoryService {
	@Autowired
	CategoryDAO cdao;

	@Override
	public List<Category> findAll() {
		return cdao.findAll();
	}

	@Override
	public Category findById(String id) {
		return cdao.findById(id).get();
	}

	@Override
	public Category create(Category category) {
		return cdao.save(category);
	}

	@Override
	public Category update(Category category) {
		return cdao.save(category);
	}

	@Override
	public void delete(String id) {
		cdao.deleteById(id);
		
	}

}
