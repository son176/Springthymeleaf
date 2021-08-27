package com.saleproduct.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saleproduct.entity.Role;

public interface RoleDAO extends JpaRepository<Role, String> {

}
