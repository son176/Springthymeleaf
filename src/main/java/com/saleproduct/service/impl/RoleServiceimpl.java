package com.saleproduct.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saleproduct.dao.RoleDAO;
import com.saleproduct.entity.Role;
import com.saleproduct.service.RoleService;
@Service
public class RoleServiceimpl implements RoleService {
   @Autowired
   RoleDAO dao;
	@Override
	public List<Role> findAll() {
		return dao.findAll();
	}

}
