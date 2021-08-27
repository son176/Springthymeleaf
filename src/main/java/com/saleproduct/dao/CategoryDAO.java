package com.saleproduct.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saleproduct.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String>{

}
